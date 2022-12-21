// 
// Decompiled by Procyon v0.5.36
// 

package com.viaversion.viaversion.protocols.protocol1_19to1_18_2;

import com.viaversion.viaversion.api.rewriter.ItemRewriter;
import com.viaversion.viaversion.api.rewriter.EntityRewriter;
import com.viaversion.viaversion.api.data.entity.EntityTracker;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.protocol1_19to1_18_2.storage.SequenceStorage;
import com.viaversion.viaversion.protocols.protocol1_19to1_18_2.storage.DimensionRegistryStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.protocols.protocol1_19to1_18_2.provider.AckSequenceProvider;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.minecraft.entities.Entity1_19Types;
import com.viaversion.viaversion.api.type.types.minecraft.ParticleType;
import com.viaversion.viaversion.api.type.types.version.Types1_19;
import java.util.concurrent.ThreadLocalRandom;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.protocols.protocol1_19to1_18_2.storage.NonceStorage;
import com.viaversion.viaversion.util.CipherUtil;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.rewriter.CommandRewriter;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.libs.kyori.adventure.text.Component;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.rewriter.StatisticsRewriter;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import com.viaversion.viaversion.rewriter.SoundRewriter;
import com.viaversion.viaversion.protocols.protocol1_19to1_18_2.packets.WorldPackets;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.protocols.protocol1_19to1_18_2.packets.InventoryPackets;
import com.viaversion.viaversion.protocols.protocol1_19to1_18_2.packets.EntityPackets;
import com.viaversion.viaversion.protocols.protocol1_19to1_18_2.data.MappingData;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.protocol1_18to1_17_1.ClientboundPackets1_18;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;

public final class Protocol1_19To1_18_2 extends AbstractProtocol<ClientboundPackets1_18, ClientboundPackets1_19, ServerboundPackets1_17, ServerboundPackets1_19>
{
    public static final MappingData MAPPINGS;
    private final EntityPackets entityRewriter;
    private final InventoryPackets itemRewriter;
    
    public Protocol1_19To1_18_2() {
        super(ClientboundPackets1_18.class, ClientboundPackets1_19.class, ServerboundPackets1_17.class, ServerboundPackets1_19.class);
        this.entityRewriter = new EntityPackets(this);
        this.itemRewriter = new InventoryPackets(this);
    }
    
    @Override
    protected void registerPackets() {
        final TagRewriter tagRewriter = new TagRewriter(this);
        tagRewriter.registerGeneric(ClientboundPackets1_18.TAGS);
        this.entityRewriter.register();
        this.itemRewriter.register();
        WorldPackets.register(this);
        ((AbstractProtocol<ClientboundPackets1_18, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_18.ADD_VIBRATION_SIGNAL);
        final SoundRewriter soundRewriter = new SoundRewriter(this);
        ((AbstractProtocol<ClientboundPackets1_18, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_18.SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.create(Type.LONG, randomLong());
                this.handler(soundRewriter.getSoundHandler());
            }
        });
        ((AbstractProtocol<ClientboundPackets1_18, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_18.ENTITY_SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.create(Type.LONG, randomLong());
                this.handler(soundRewriter.getSoundHandler());
            }
        });
        ((AbstractProtocol<ClientboundPackets1_18, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_18.NAMED_SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.VAR_INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.create(Type.LONG, randomLong());
            }
        });
        new StatisticsRewriter(this).register(ClientboundPackets1_18.STATISTICS);
        final JsonElement component;
        final PacketHandler titleHandler = wrapper -> {
            component = wrapper.read(Type.COMPONENT);
            if (!component.isJsonNull()) {
                wrapper.write(Type.COMPONENT, component);
            }
            else {
                wrapper.write(Type.COMPONENT, GsonComponentSerializer.gson().serializeToTree(Component.empty()));
            }
            return;
        };
        ((AbstractProtocol<ClientboundPackets1_18, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_18.TITLE_TEXT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(titleHandler);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_18, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_18.TITLE_SUBTITLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(titleHandler);
            }
        });
        final CommandRewriter commandRewriter = new CommandRewriter(this);
        ((AbstractProtocol<ClientboundPackets1_18, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_18.DECLARE_COMMANDS, new PacketRemapper() {
            @Override
            public void registerMap() {
                final CommandRewriter val$commandRewriter;
                int size;
                int i;
                byte flags;
                int nodeType;
                String argumentType;
                int argumentTypeId;
                this.handler(wrapper -> {
                    val$commandRewriter = commandRewriter;
                    for (size = wrapper.passthrough((Type<Integer>)Type.VAR_INT), i = 0; i < size; ++i) {
                        flags = wrapper.passthrough((Type<Byte>)Type.BYTE);
                        wrapper.passthrough(Type.VAR_INT_ARRAY_PRIMITIVE);
                        if ((flags & 0x8) != 0x0) {
                            wrapper.passthrough((Type<Object>)Type.VAR_INT);
                        }
                        nodeType = (flags & 0x3);
                        if (nodeType == 1 || nodeType == 2) {
                            wrapper.passthrough(Type.STRING);
                        }
                        if (nodeType == 2) {
                            argumentType = wrapper.read(Type.STRING);
                            argumentTypeId = Protocol1_19To1_18_2.MAPPINGS.getArgumentTypeMappings().mappedId(argumentType);
                            if (argumentTypeId == -1) {
                                Via.getPlatform().getLogger().warning("Unknown command argument type: " + argumentType);
                            }
                            wrapper.write(Type.VAR_INT, argumentTypeId);
                            val$commandRewriter.handleArgument(wrapper, argumentType);
                            if ((flags & 0x10) != 0x0) {
                                wrapper.passthrough(Type.STRING);
                            }
                        }
                    }
                    wrapper.passthrough((Type<Object>)Type.VAR_INT);
                });
            }
        });
        ((Protocol<ClientboundPackets1_18, ClientboundPackets1_19, S1, S2>)this).registerClientbound(ClientboundPackets1_18.CHAT_MESSAGE, ClientboundPackets1_19.SYSTEM_CHAT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.COMPONENT);
                final int type;
                this.handler(wrapper -> {
                    type = wrapper.read((Type<Byte>)Type.BYTE);
                    wrapper.write(Type.VAR_INT, (type == 0) ? 1 : type);
                    return;
                });
                this.read(Type.UUID);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_19>)this).registerServerbound(ServerboundPackets1_19.CHAT_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.read(Type.LONG);
                this.read(Type.LONG);
                this.read(Type.BYTE_ARRAY_PRIMITIVE);
                this.read(Type.BOOLEAN);
            }
        });
        ((Protocol<C1, C2, ServerboundPackets1_17, ServerboundPackets1_19>)this).registerServerbound(ServerboundPackets1_19.CHAT_COMMAND, ServerboundPackets1_17.CHAT_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.read(Type.LONG);
                this.read(Type.LONG);
                final String command;
                int signatures;
                int i;
                this.handler(wrapper -> {
                    command = wrapper.get(Type.STRING, 0);
                    wrapper.set(Type.STRING, 0, "/" + command);
                    for (signatures = wrapper.read((Type<Integer>)Type.VAR_INT), i = 0; i < signatures; ++i) {
                        wrapper.read(Type.STRING);
                        wrapper.read(Type.BYTE_ARRAY_PRIMITIVE);
                    }
                    return;
                });
                this.read(Type.BOOLEAN);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_19>)this).cancelServerbound(ServerboundPackets1_19.CHAT_PREVIEW);
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.GAME_PROFILE.getId(), ClientboundLoginPackets.GAME_PROFILE.getId(), new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UUID);
                this.map(Type.STRING);
                this.create(Type.VAR_INT, 0);
            }
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.HELLO.getId(), ClientboundLoginPackets.HELLO.getId(), new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                final byte[] publicKey;
                final byte[] nonce;
                this.handler(wrapper -> {
                    publicKey = wrapper.passthrough(Type.BYTE_ARRAY_PRIMITIVE);
                    nonce = wrapper.passthrough(Type.BYTE_ARRAY_PRIMITIVE);
                    wrapper.user().put(new NonceStorage(CipherUtil.encryptNonce(publicKey, nonce)));
                });
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.HELLO.getId(), ServerboundLoginPackets.HELLO.getId(), new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.read(Type.OPTIONAL_PROFILE_KEY);
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.ENCRYPTION_KEY.getId(), ServerboundLoginPackets.ENCRYPTION_KEY.getId(), new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.BYTE_ARRAY_PRIMITIVE);
                NonceStorage nonceStorage;
                this.handler(wrapper -> {
                    if (wrapper.read((Type<Boolean>)Type.BOOLEAN)) {
                        wrapper.passthrough(Type.BYTE_ARRAY_PRIMITIVE);
                    }
                    else {
                        nonceStorage = wrapper.user().remove(NonceStorage.class);
                        if (nonceStorage == null) {
                            throw new IllegalArgumentException("Server sent nonce is missing");
                        }
                        else {
                            wrapper.read((Type<Object>)Type.LONG);
                            wrapper.read(Type.BYTE_ARRAY_PRIMITIVE);
                            wrapper.write(Type.BYTE_ARRAY_PRIMITIVE, nonceStorage.nonce());
                        }
                    }
                });
            }
        });
    }
    
    private static long randomLong() {
        return ThreadLocalRandom.current().nextLong();
    }
    
    @Override
    protected void onMappingDataLoaded() {
        Types1_19.PARTICLE.filler(this).reader("block", ParticleType.Readers.BLOCK).reader("block_marker", ParticleType.Readers.BLOCK).reader("dust", ParticleType.Readers.DUST).reader("falling_dust", ParticleType.Readers.BLOCK).reader("dust_color_transition", ParticleType.Readers.DUST_TRANSITION).reader("item", ParticleType.Readers.VAR_INT_ITEM).reader("vibration", ParticleType.Readers.VIBRATION).reader("sculk_charge", ParticleType.Readers.SCULK_CHARGE).reader("shriek", ParticleType.Readers.SHRIEK);
        Entity1_19Types.initialize(this);
        this.entityRewriter.onMappingDataLoaded();
    }
    
    @Override
    public void register(final ViaProviders providers) {
        providers.register(AckSequenceProvider.class, new AckSequenceProvider());
    }
    
    @Override
    public void init(final UserConnection user) {
        if (!user.has(DimensionRegistryStorage.class)) {
            user.put(new DimensionRegistryStorage());
        }
        user.put(new SequenceStorage());
        this.addEntityTracker(user, new EntityTrackerBase(user, Entity1_19Types.PLAYER));
    }
    
    @Override
    public MappingData getMappingData() {
        return Protocol1_19To1_18_2.MAPPINGS;
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.entityRewriter;
    }
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.itemRewriter;
    }
    
    static {
        MAPPINGS = new MappingData();
    }
}
