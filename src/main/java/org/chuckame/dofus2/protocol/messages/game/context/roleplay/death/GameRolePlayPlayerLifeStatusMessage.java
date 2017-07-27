package org.chuckame.dofus2.protocol.messages.game.context.roleplay.death;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameRolePlayPlayerLifeStatusMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5996;
	
	private byte state;
	
	public GameRolePlayPlayerLifeStatusMessage() {
	}
	
	public GameRolePlayPlayerLifeStatusMessage(byte state) {
		this.state = state;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.state = reader.readSByte();
		if (state < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on state = %s, it doesn't respect the following condition : state < 0", state));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.state);
	}
}