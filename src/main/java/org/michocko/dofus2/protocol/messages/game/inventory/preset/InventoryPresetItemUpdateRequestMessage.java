package org.michocko.dofus2.protocol.messages.game.inventory.preset;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class InventoryPresetItemUpdateRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6210;
	
	private byte presetId;
	private short position;
	private int objUid;
	
	public InventoryPresetItemUpdateRequestMessage() {
	}
	
	public InventoryPresetItemUpdateRequestMessage(byte presetId, short position, int objUid) {
		this.presetId = presetId;
		this.position = position;
		this.objUid = objUid;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.presetId = reader.readSByte();
		if (presetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on presetId = %s, it doesn't respect the following condition : presetId < 0", presetId));
		this.position = reader.readByte();
		if (position < 0 || position > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on position = %s, it doesn't respect the following condition : position < 0 || position > 255", position));
		this.objUid = reader.readInt();
		if (objUid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objUid = %s, it doesn't respect the following condition : objUid < 0", objUid));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.presetId);
		writer.writeByte(this.position);
		writer.writeInt(this.objUid);
	}
}