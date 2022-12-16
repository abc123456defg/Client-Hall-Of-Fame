// 
// Decompiled by Procyon v0.5.36
// 

package com.bulenkov.darcula.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.SwingUtilities;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

public abstract class Animator
{
    private static final ScheduledExecutorService scheduler;
    private final int myTotalFrames;
    private final int myCycleDuration;
    private final boolean myForward;
    private final boolean myRepeatable;
    private ScheduledFuture<?> myTicker;
    private int myCurrentFrame;
    private long myStartTime;
    private long myStopTime;
    private volatile boolean myDisposed;
    
    private static ScheduledExecutorService createScheduler() {
        final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
            @Override
            public Thread newThread(final Runnable r) {
                final Thread thread = new Thread(r, "Darcula Animations");
                thread.setDaemon(true);
                thread.setPriority(5);
                return thread;
            }
        });
        executor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
        executor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        return executor;
    }
    
    public Animator(final String name, final int totalFrames, final int cycleDuration, final boolean repeatable) {
        this(name, totalFrames, cycleDuration, repeatable, true);
    }
    
    public Animator(final String name, final int totalFrames, final int cycleDuration, final boolean repeatable, final boolean forward) {
        this.myDisposed = false;
        this.myTotalFrames = totalFrames;
        this.myCycleDuration = cycleDuration;
        this.myRepeatable = repeatable;
        this.myForward = forward;
        this.myCurrentFrame = (forward ? 0 : totalFrames);
        this.reset();
    }
    
    private void onTick() {
        if (this.isDisposed()) {
            return;
        }
        if (this.myStartTime == -1L) {
            this.myStartTime = System.currentTimeMillis();
            this.myStopTime = this.myStartTime + this.myCycleDuration * (this.myTotalFrames - this.myCurrentFrame) / this.myTotalFrames;
        }
        final double passedTime = (double)(System.currentTimeMillis() - this.myStartTime);
        final double totalTime = (double)(this.myStopTime - this.myStartTime);
        final int newFrame = (int)(passedTime * this.myTotalFrames / totalTime);
        if (this.myCurrentFrame > 0 && newFrame == this.myCurrentFrame) {
            return;
        }
        this.myCurrentFrame = newFrame;
        if (this.myCurrentFrame >= this.myTotalFrames) {
            if (!this.myRepeatable) {
                this.animationDone();
                return;
            }
            this.reset();
        }
        this.paint();
    }
    
    private void paint() {
        this.paintNow(this.myForward ? this.myCurrentFrame : (this.myTotalFrames - this.myCurrentFrame - 1), this.myTotalFrames, this.myCycleDuration);
    }
    
    private void animationDone() {
        this.stopTicker();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Animator.this.paintCycleEnd();
            }
        });
    }
    
    private void stopTicker() {
        if (this.myTicker != null) {
            this.myTicker.cancel(false);
            this.myTicker = null;
        }
    }
    
    protected void paintCycleEnd() {
    }
    
    public void suspend() {
        this.myStartTime = -1L;
        this.stopTicker();
    }
    
    public void resume() {
        if (this.myCycleDuration == 0) {
            this.myCurrentFrame = this.myTotalFrames - 1;
            this.paint();
            this.animationDone();
        }
        else if (this.myTicker == null) {
            this.myTicker = Animator.scheduler.scheduleWithFixedDelay(new Runnable() {
                AtomicBoolean scheduled = new AtomicBoolean(false);
                
                @Override
                public void run() {
                    if (this.scheduled.compareAndSet(false, true) && !Animator.this.isDisposed()) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                Runnable.this.scheduled.set(false);
                                Animator.this.onTick();
                            }
                        });
                    }
                }
            }, 0L, this.myCycleDuration * 1000 / this.myTotalFrames, TimeUnit.MICROSECONDS);
        }
    }
    
    public abstract void paintNow(final int p0, final int p1, final int p2);
    
    public void dispose() {
        this.myDisposed = true;
        this.stopTicker();
    }
    
    public boolean isRunning() {
        return this.myTicker != null;
    }
    
    public void reset() {
        this.myCurrentFrame = 0;
        this.myStartTime = -1L;
    }
    
    public final boolean isForward() {
        return this.myForward;
    }
    
    public boolean isDisposed() {
        return this.myDisposed;
    }
    
    static {
        scheduler = createScheduler();
    }
}
