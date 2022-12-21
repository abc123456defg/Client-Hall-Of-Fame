// 
// Decompiled by Procyon v0.5.36
// 

package com.viaversion.viaversion.protocols.protocol1_19to1_18_2.packets;

import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.protocols.protocol1_19to1_18_2.ServerboundPackets1_19;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.data.entity.EntityTracker;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.protocols.protocol1_18to1_17_1.types.Chunk1_18Type;
import com.viaversion.viaversion.util.MathUtil;
import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.protocol.remapper.PacketRemapper;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.protocols.protocol1_18to1_17_1.ClientboundPackets1_18;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.protocols.protocol1_19to1_18_2.Protocol1_19To1_18_2;

public final class WorldPackets
{
    public static void register(final Protocol1_19To1_18_2 protocol) {
        final BlockRewriter blockRewriter = new BlockRewriter(protocol, Type.POSITION1_14);
        blockRewriter.registerBlockAction(ClientboundPackets1_18.BLOCK_ACTION);
        blockRewriter.registerBlockChange(ClientboundPackets1_18.BLOCK_CHANGE);
        blockRewriter.registerVarLongMultiBlockChange(ClientboundPackets1_18.MULTI_BLOCK_CHANGE);
        blockRewriter.registerEffect(ClientboundPackets1_18.EFFECT, 1010, 2001);
        ((AbstractProtocol<ClientboundPackets1_18, C2, S1, S2>)protocol).cancelClientbound(ClientboundPackets1_18.ACKNOWLEDGE_PLAYER_DIGGING);
        ((AbstractProtocol<ClientboundPackets1_18, C2, S1, S2>)protocol).registerClientbound(ClientboundPackets1_18.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Protocol1_19To1_18_2 val$protocol;
                final EntityTracker tracker;
                final Chunk1_18Type chunkType;
                final Chunk chunk;
                final ChunkSection[] array;
                int length;
                int j = 0;
                ChunkSection section;
                DataPalette blockPalette;
                int i;
                int id;
                this.handler(wrapper -> {
                    val$protocol = protocol;
                    tracker = val$protocol.getEntityRewriter().tracker(wrapper.user());
                    Preconditions.checkArgument(tracker.biomesSent() != 0, (Object)"Biome count not set");
                    Preconditions.checkArgument(tracker.currentWorldSectionHeight() != 0, (Object)"Section height not set");
                    chunkType = new Chunk1_18Type(tracker.currentWorldSectionHeight(), MathUtil.ceilLog2(val$protocol.getMappingData().getBlockStateMappings().mappedSize()), MathUtil.ceilLog2(tracker.biomesSent()));
                    chunk = wrapper.passthrough((Type<Chunk>)chunkType);
                    chunk.getSections();
                    for (length = array.length; j < length; ++j) {
                        section = array[j];
                        for (blockPalette = section.palette(PaletteType.BLOCKS), i = 0; i < blockPalette.size(); ++i) {
                            id = blockPalette.idByIndex(i);
                            blockPalette.setIdByIndex(i, val$protocol.getMappingData().getNewBlockStateId(id));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_19>)protocol).registerServerbound(ServerboundPackets1_19.SET_BEACON_EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(wrapper -> {
                    if (wrapper.read((Type<Boolean>)Type.BOOLEAN)) {
                        wrapper.passthrough((Type<Object>)Type.VAR_INT);
                    }
                    else {
                        wrapper.write(Type.VAR_INT, -1);
                    }
                    if (wrapper.read((Type<Boolean>)Type.BOOLEAN)) {
                        wrapper.passthrough((Type<Object>)Type.VAR_INT);
                    }
                    else {
                        wrapper.write(Type.VAR_INT, -1);
                    }
                });
            }
        });
    }
}
