package org.chuckame.dofus2.protocol.messages.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameFightOptionToggleMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 707;
	
	private byte option;
	
	public GameFightOptionToggleMessage() {
	}
	
	public GameFightOptionToggleMessage(byte option) {
		this.option = option;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.option = reader.readSByte();
		if (option < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on option = %s, it doesn't respect the following condition : option < 0", option));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.option);
	}
}