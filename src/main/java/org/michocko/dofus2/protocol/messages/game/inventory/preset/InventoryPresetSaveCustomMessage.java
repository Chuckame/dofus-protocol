package org.michocko.dofus2.protocol.messages.game.inventory.preset;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class InventoryPresetSaveCustomMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6329;
	
	private byte presetId;
	private byte symbolId;
	private Collection<Short> itemsPositions;
	private Collection<Integer> itemsUids;
	
	public InventoryPresetSaveCustomMessage() {
	}
	
	public InventoryPresetSaveCustomMessage(byte presetId, byte symbolId, Collection<Short> itemsPositions, Collection<Integer> itemsUids) {
		this.presetId = presetId;
		this.symbolId = symbolId;
		this.itemsPositions = itemsPositions;
		this.itemsUids = itemsUids;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.presetId = reader.readSByte();
		if (presetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on presetId = %s, it doesn't respect the following condition : presetId < 0", presetId));
		this.symbolId = reader.readSByte();
		if (symbolId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on symbolId = %s, it doesn't respect the following condition : symbolId < 0", symbolId));
		int length = reader.readUShort();
		this.itemsPositions = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readByte();
			this.itemsPositions.add(entry);
		}
		length = reader.readUShort();
		this.itemsUids = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.itemsUids.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.presetId);
		writer.writeSByte(this.symbolId);
		writer.writeUShort(this.itemsPositions.size());
		for (short entry : this.itemsPositions)
		{
			writer.writeByte(entry);
		}
		writer.writeUShort(this.itemsUids.size());
		for (int entry : this.itemsUids)
		{
			writer.writeInt(entry);
		}
	}
}