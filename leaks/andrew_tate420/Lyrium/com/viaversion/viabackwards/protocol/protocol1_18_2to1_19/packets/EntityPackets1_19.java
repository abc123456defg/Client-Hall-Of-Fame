// 
// Decompiled by Procyon v0.5.36
// 

package com.viaversion.viabackwards.protocol.protocol1_18_2to1_19.packets;

import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.minecraft.metadata.Metadata;
import com.viaversion.viaversion.rewriter.meta.MetaHandlerEvent;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.minecraft.metadata.MetaType;
import com.viaversion.viaversion.api.type.types.Particle;
import java.util.Iterator;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.NumberTag;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.Tag;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.ListTag;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.viaversion.viabackwards.protocol.protocol1_18_2to1_19.storage.DimensionRegistryStorage;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.data.entity.StoredEntityData;
import com.viaversion.viabackwards.protocol.protocol1_18_2to1_19.storage.StoredPainting;
import java.util.UUID;
import com.viaversion.viaversion.api.minecraft.Position;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.protocols.protocol1_18to1_17_1.ClientboundPackets1_18;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import com.viaversion.viaversion.api.type.types.version.Types1_18;
import com.viaversion.viaversion.api.type.types.version.Types1_19;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.minecraft.entities.Entity1_19Types;
import com.viaversion.viaversion.protocols.protocol1_19to1_18_2.ClientboundPackets1_19;
import com.viaversion.viabackwards.protocol.protocol1_18_2to1_19.Protocol1_18_2To1_19;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;

public final class EntityPackets1_19 extends EntityRewriter<Protocol1_18_2To1_19>
{
    public EntityPackets1_19(final Protocol1_18_2To1_19 protocol) {
        super(protocol);
    }
    
    @Override
    protected void registerPackets() {
        this.registerTracker(ClientboundPackets1_19.SPAWN_EXPERIENCE_ORB, Entity1_19Types.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_19.SPAWN_PLAYER, Entity1_19Types.PLAYER);
        this.registerMetadataRewriter(ClientboundPackets1_19.ENTITY_METADATA, Types1_19.METADATA_LIST, Types1_18.METADATA_LIST);
        this.registerRemoveEntities(ClientboundPackets1_19.REMOVE_ENTITIES);
        ((AbstractProtocol<ClientboundPackets1_19, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_19.SPAWN_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.VAR_INT);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                final byte headYaw;
                int data;
                final EntityType entityType;
                byte pitch;
                byte yaw;
                int entityId;
                StoredEntityData entityData;
                Position position;
                this.handler(wrapper -> {
                    headYaw = wrapper.read((Type<Byte>)Type.BYTE);
                    data = wrapper.read((Type<Integer>)Type.VAR_INT);
                    entityType = EntityRewriter.this.setOldEntityId(wrapper);
                    if (entityType.isOrHasParent(Entity1_19Types.LIVINGENTITY)) {
                        wrapper.write(Type.BYTE, headYaw);
                        pitch = wrapper.get((Type<Byte>)Type.BYTE, 0);
                        yaw = wrapper.get((Type<Byte>)Type.BYTE, 1);
                        wrapper.set(Type.BYTE, 0, yaw);
                        wrapper.set(Type.BYTE, 1, pitch);
                        wrapper.setPacketType(ClientboundPackets1_18.SPAWN_MOB);
                    }
                    else if (entityType == Entity1_19Types.PAINTING) {
                        wrapper.cancel();
                        entityId = wrapper.get((Type<Integer>)Type.VAR_INT, 0);
                        entityData = ((com.viaversion.viaversion.api.rewriter.EntityRewriter<Protocol>)EntityPackets1_19.this).tracker(wrapper.user()).entityData(entityId);
                        position = new Position(wrapper.get((Type<Double>)Type.DOUBLE, 0).intValue(), wrapper.get((Type<Double>)Type.DOUBLE, 1).intValue(), wrapper.get((Type<Double>)Type.DOUBLE, 2).intValue());
                        entityData.put(new StoredPainting(entityId, wrapper.get(Type.UUID, 0), position, data));
                    }
                    else {
                        if (entityType == Entity1_19Types.FALLING_BLOCK) {
                            data = ((Protocol1_18_2To1_19)EntityPackets1_19.this.protocol).getMappingData().getNewBlockStateId(data);
                        }
                        wrapper.write(Type.INT, data);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_19, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_19.ENTITY_EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.handler(wrapper -> {
                    if (wrapper.read((Type<Boolean>)Type.BOOLEAN)) {
                        wrapper.read(Type.NBT);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_19, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_19.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.BYTE);
                this.map(Type.STRING_ARRAY);
                this.map(Type.NBT);
                final DimensionRegistryStorage dimensionRegistryStorage;
                final String dimensionKey;
                final CompoundTag registry;
                final ListTag dimensions;
                boolean found;
                final Iterator<Tag> iterator;
                Tag dimension;
                CompoundTag dimensionCompound;
                StringTag nameTag;
                CompoundTag dimensionData;
                final IllegalStateException ex;
                CompoundTag biomeRegistry;
                ListTag biomes;
                final Iterator<Tag> iterator2;
                Tag biome;
                CompoundTag biomeCompound;
                ListTag chatTypes;
                final Iterator<Tag> iterator3;
                Tag chatType;
                CompoundTag chatTypeCompound;
                NumberTag idTag;
                this.handler(wrapper -> {
                    dimensionRegistryStorage = wrapper.user().get(DimensionRegistryStorage.class);
                    dimensionRegistryStorage.clear();
                    dimensionKey = wrapper.read(Type.STRING);
                    registry = wrapper.get(Type.NBT, 0);
                    dimensions = registry.get("minecraft:dimension_type").get("value");
                    found = false;
                    dimensions.iterator();
                    while (iterator.hasNext()) {
                        dimension = iterator.next();
                        dimensionCompound = (CompoundTag)dimension;
                        nameTag = dimensionCompound.get("name");
                        dimensionData = dimensionCompound.get("element");
                        dimensionRegistryStorage.addDimension(nameTag.getValue(), dimensionData.clone());
                        if (!found && nameTag.getValue().equals(dimensionKey)) {
                            wrapper.write(Type.NBT, dimensionData);
                            found = true;
                        }
                    }
                    if (!found) {
                        new IllegalStateException("Could not find dimension " + dimensionKey + " in dimension registry");
                        throw ex;
                    }
                    else {
                        biomeRegistry = registry.get("minecraft:worldgen/biome");
                        biomes = biomeRegistry.get("value");
                        biomes.getValue().iterator();
                        while (iterator2.hasNext()) {
                            biome = iterator2.next();
                            biomeCompound = ((CompoundTag)biome).get("element");
                            biomeCompound.put("category", new StringTag("none"));
                        }
                        ((com.viaversion.viaversion.api.rewriter.EntityRewriter<Protocol>)EntityPackets1_19.this).tracker(wrapper.user()).setBiomesSent(biomes.size());
                        chatTypes = registry.remove("minecraft:chat_type").get("value");
                        chatTypes.iterator();
                        while (iterator3.hasNext()) {
                            chatType = iterator3.next();
                            chatTypeCompound = (CompoundTag)chatType;
                            idTag = chatTypeCompound.get("id");
                            dimensionRegistryStorage.addChatType(idTag.asInt(), chatTypeCompound);
                        }
                        return;
                    }
                });
                this.map(Type.STRING);
                this.map(Type.LONG);
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.BOOLEAN);
                this.map(Type.BOOLEAN);
                this.map(Type.BOOLEAN);
                this.map(Type.BOOLEAN);
                this.read(Type.OPTIONAL_GLOBAL_POSITION);
                this.handler(EntityPackets1_19.this.worldDataTrackerHandler(1));
                this.handler(EntityPackets1_19.this.playerTrackerHandler());
            }
        });
        ((AbstractProtocol<ClientboundPackets1_19, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_19.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                final String dimensionKey;
                final CompoundTag dimension;
                final IllegalArgumentException ex;
                this.handler(wrapper -> {
                    dimensionKey = wrapper.read(Type.STRING);
                    dimension = wrapper.user().get(DimensionRegistryStorage.class).dimension(dimensionKey);
                    if (dimension == null) {
                        new IllegalArgumentException("Could not find dimension " + dimensionKey + " in dimension registry");
                        throw ex;
                    }
                    else {
                        wrapper.write(Type.NBT, dimension);
                        return;
                    }
                });
                this.map(Type.STRING);
                this.map(Type.LONG);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
                this.map(Type.BOOLEAN);
                this.map(Type.BOOLEAN);
                this.read(Type.OPTIONAL_GLOBAL_POSITION);
                this.handler(EntityPackets1_19.this.worldDataTrackerHandler(0));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_19, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_19.PLAYER_INFO, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int action;
                int entries;
                int i;
                int properties;
                int j;
                this.handler(wrapper -> {
                    action = wrapper.passthrough((Type<Integer>)Type.VAR_INT);
                    for (entries = wrapper.passthrough((Type<Integer>)Type.VAR_INT), i = 0; i < entries; ++i) {
                        wrapper.passthrough(Type.UUID);
                        if (action == 0) {
                            wrapper.passthrough(Type.STRING);
                            for (properties = wrapper.passthrough((Type<Integer>)Type.VAR_INT), j = 0; j < properties; ++j) {
                                wrapper.passthrough(Type.STRING);
                                wrapper.passthrough(Type.STRING);
                                if (wrapper.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                    wrapper.passthrough(Type.STRING);
                                }
                            }
                            wrapper.passthrough((Type<Object>)Type.VAR_INT);
                            wrapper.passthrough((Type<Object>)Type.VAR_INT);
                            if (wrapper.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                wrapper.passthrough(Type.COMPONENT);
                            }
                            wrapper.read(Type.OPTIONAL_PROFILE_KEY);
                        }
                        else if (action == 1 || action == 2) {
                            wrapper.passthrough((Type<Object>)Type.VAR_INT);
                        }
                        else if (action == 3 && wrapper.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                            wrapper.passthrough(Type.COMPONENT);
                        }
                    }
                });
            }
        });
    }
    
    @Override
    public void onMappingDataLoaded() {
        final MetaType type;
        Particle particle;
        ParticleMappings particleMappings;
        int pose;
        this.filter().handler((event, meta) -> {
            if (meta.metaType().typeId() <= Types1_18.META_TYPES.poseType.typeId()) {
                meta.setMetaType(Types1_18.META_TYPES.byId(meta.metaType().typeId()));
            }
            type = meta.metaType();
            if (type == Types1_18.META_TYPES.particleType) {
                particle = (Particle)meta.getValue();
                particleMappings = ((Protocol1_18_2To1_19)this.protocol).getMappingData().getParticleMappings();
                if (particle.getId() == particleMappings.id("sculk_charge")) {
                    event.cancel();
                }
                else if (particle.getId() == particleMappings.id("shriek")) {
                    event.cancel();
                }
                else if (particle.getId() == particleMappings.id("vibration")) {
                    event.cancel();
                }
                else {
                    this.rewriteParticle(particle);
                }
            }
            else if (type == Types1_18.META_TYPES.poseType) {
                pose = (int)meta.value();
                if (pose >= 8) {
                    meta.setValue(0);
                }
            }
            return;
        });
        this.registerMetaTypeHandler(Types1_18.META_TYPES.itemType, Types1_18.META_TYPES.blockStateType, null, Types1_18.META_TYPES.optionalComponentType);
        this.mapTypes();
        final int data;
        this.filter().filterFamily(Entity1_19Types.MINECART_ABSTRACT).index(11).handler((event, meta) -> {
            data = (int)meta.getValue();
            meta.setValue(((Protocol1_18_2To1_19)this.protocol).getMappingData().getNewBlockStateId(data));
            return;
        });
        final StoredEntityData entityData;
        final StoredPainting storedPainting;
        PacketWrapper packet;
        this.filter().type(Entity1_19Types.PAINTING).index(8).handler((event, meta) -> {
            event.cancel();
            entityData = ((com.viaversion.viaversion.api.rewriter.EntityRewriter<Protocol>)this).tracker(event.user()).entityDataIfPresent(event.entityId());
            storedPainting = entityData.remove(StoredPainting.class);
            if (storedPainting != null) {
                packet = PacketWrapper.create(ClientboundPackets1_18.SPAWN_PAINTING, event.user());
                packet.write(Type.VAR_INT, storedPainting.entityId());
                packet.write(Type.UUID, storedPainting.uuid());
                packet.write(Type.VAR_INT, (Integer)meta.value());
                packet.write(Type.POSITION1_14, storedPainting.position());
                packet.write(Type.BYTE, storedPainting.direction());
                try {
                    packet.send(Protocol1_18_2To1_19.class);
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            return;
        });
        this.filter().type(Entity1_19Types.CAT).index(19).handler((event, meta) -> meta.setMetaType(Types1_18.META_TYPES.varIntType));
        this.filter().type(Entity1_19Types.FROG).cancel(16);
        this.filter().type(Entity1_19Types.FROG).cancel(17);
        this.filter().type(Entity1_19Types.FROG).cancel(18);
        this.mapEntityTypeWithData(Entity1_19Types.FROG, Entity1_19Types.RABBIT).jsonName();
        this.mapEntityTypeWithData(Entity1_19Types.TADPOLE, Entity1_19Types.PUFFERFISH).jsonName();
        this.mapEntityTypeWithData(Entity1_19Types.CHEST_BOAT, Entity1_19Types.BOAT);
        this.filter().type(Entity1_19Types.WARDEN).cancel(16);
        this.mapEntityTypeWithData(Entity1_19Types.WARDEN, Entity1_19Types.IRON_GOLEM).jsonName();
        this.mapEntityTypeWithData(Entity1_19Types.ALLAY, Entity1_19Types.VEX).jsonName();
        this.filter().type(Entity1_19Types.GOAT).cancel(18);
        this.filter().type(Entity1_19Types.GOAT).cancel(19);
    }
    
    @Override
    public EntityType typeFromId(final int typeId) {
        return Entity1_19Types.getTypeFromId(typeId);
    }
}
