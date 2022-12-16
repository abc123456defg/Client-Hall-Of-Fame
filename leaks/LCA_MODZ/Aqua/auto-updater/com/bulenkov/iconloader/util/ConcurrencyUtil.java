// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.iconloader.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ConcurrentMap;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CancellationException;
import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;
import java.util.Collection;

public class ConcurrencyUtil
{
    public static <T> List<Future<T>> invokeAll(final Collection<Callable<T>> tasks, final ExecutorService executorService) throws Throwable {
        if (executorService == null) {
            for (final Callable<T> task : tasks) {
                task.call();
            }
            return null;
        }
        final List<Future<T>> futures = new ArrayList<Future<T>>(tasks.size());
        boolean done = false;
        try {
            for (final Callable<T> t : tasks) {
                final Future<T> future = executorService.submit(t);
                futures.add(future);
            }
            for (final Future f : futures) {
                ((Runnable)f).run();
            }
            for (final Future f : futures) {
                try {
                    f.get();
                }
                catch (CancellationException ex) {}
                catch (ExecutionException e) {
                    final Throwable cause = e.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    continue;
                }
            }
            done = true;
        }
        finally {
            if (!done) {
                for (final Future f2 : futures) {
                    f2.cancel(false);
                }
            }
        }
        return futures;
    }
    
    public static <K, V> V cacheOrGet(final ConcurrentMap<K, V> map, final K key, final V defaultValue) {
        final V v = map.get(key);
        if (v != null) {
            return v;
        }
        final V prev = map.putIfAbsent(key, defaultValue);
        return (prev == null) ? defaultValue : prev;
    }
    
    public static ThreadPoolExecutor newSingleThreadExecutor(final String threadFactoryName) {
        return newSingleThreadExecutor(threadFactoryName, 5);
    }
    
    public static ThreadPoolExecutor newSingleThreadExecutor(final String threadFactoryName, final int threadPriority) {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), newNamedThreadFactory(threadFactoryName, true, threadPriority));
    }
    
    public static ScheduledThreadPoolExecutor newSingleScheduledThreadExecutor(final String threadFactoryName) {
        return newSingleScheduledThreadExecutor(threadFactoryName, 5);
    }
    
    public static ScheduledThreadPoolExecutor newSingleScheduledThreadExecutor(final String threadFactoryName, final int threadPriority) {
        final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, newNamedThreadFactory(threadFactoryName, true, threadPriority));
        executor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
        executor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        return executor;
    }
    
    public static ThreadFactory newNamedThreadFactory(final String threadName, final boolean isDaemon, final int threadPriority) {
        return new ThreadFactory() {
            @Override
            public Thread newThread(final Runnable r) {
                final Thread thread = new Thread(r, threadName);
                thread.setDaemon(isDaemon);
                thread.setPriority(threadPriority);
                return thread;
            }
        };
    }
    
    public static ThreadFactory newNamedThreadFactory(final String threadName) {
        return new ThreadFactory() {
            @Override
            public Thread newThread(final Runnable r) {
                return new Thread(r, threadName);
            }
        };
    }
}
