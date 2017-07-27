package org.chuckame.dofus2.protocol.messages.game.context.roleplay.objects;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ObjectGroundRemovedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 3014;
	
	private short cell;
	
	public ObjectGroundRemovedMessage() {
	}
	
	public ObjectGroundRemovedMessage(short cell) {
		this.cell = cell;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.cell = reader.readShort();
		if (cell < 0 || cell > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on cell = %s, it doesn't respect the following condition : cell < 0 || cell > 559", cell));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.cell);
	}
}