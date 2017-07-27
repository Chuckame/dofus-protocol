package org.chuckame.dofus2.protocol.messages.game.context.display;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class DisplayNumericalValueMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5808;
	
	private int entityId;
	private int value;
	private byte type;
	
	public DisplayNumericalValueMessage() {
	}
	
	public DisplayNumericalValueMessage(int entityId, int value, byte type) {
		this.entityId = entityId;
		this.value = value;
		this.type = type;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.entityId = reader.readInt();
		this.value = reader.readInt();
		this.type = reader.readSByte();
		if (type < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on type = %s, it doesn't respect the following condition : type < 0", type));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.entityId);
		writer.writeInt(this.value);
		writer.writeSByte(this.type);
	}
}