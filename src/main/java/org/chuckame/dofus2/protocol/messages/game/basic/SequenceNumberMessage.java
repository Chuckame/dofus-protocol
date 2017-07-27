package org.chuckame.dofus2.protocol.messages.game.basic;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SequenceNumberMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6317;
	
	private int number;
	
	public SequenceNumberMessage() {
	}
	
	public SequenceNumberMessage(int number) {
		this.number = number;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.number = reader.readUShort();
		if (number < 0 || number > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on number = %s, it doesn't respect the following condition : number < 0 || number > 65535", number));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.number);
	}
}