package org.chuckame.dofus2.protocol.messages.game.inventory.items;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ObjectErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 3004;
	
	private byte reason;
	
	public ObjectErrorMessage() {
	}
	
	public ObjectErrorMessage(byte reason) {
		this.reason = reason;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.reason = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.reason);
	}
}