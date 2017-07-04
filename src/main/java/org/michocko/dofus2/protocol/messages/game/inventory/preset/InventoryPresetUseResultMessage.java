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
public class InventoryPresetUseResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6163;
	
	private byte presetId;
	private byte code;
	private Collection<Short> unlinkedPosition;
	
	public InventoryPresetUseResultMessage() {
	}
	
	public InventoryPresetUseResultMessage(byte presetId, byte code, Collection<Short> unlinkedPosition) {
		this.presetId = presetId;
		this.code = code;
		this.unlinkedPosition = unlinkedPosition;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.presetId = reader.readSByte();
		if (presetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on presetId = %s, it doesn't respect the following condition : presetId < 0", presetId));
		this.code = reader.readSByte();
		if (code < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on code = %s, it doesn't respect the following condition : code < 0", code));
		int length = reader.readUShort();
		this.unlinkedPosition = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readByte();
			this.unlinkedPosition.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.presetId);
		writer.writeSByte(this.code);
		writer.writeUShort(this.unlinkedPosition.size());
		for (short entry : this.unlinkedPosition)
		{
			writer.writeByte(entry);
		}
	}
}