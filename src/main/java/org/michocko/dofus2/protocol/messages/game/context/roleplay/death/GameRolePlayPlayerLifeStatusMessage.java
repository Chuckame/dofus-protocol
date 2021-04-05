package org.michocko.dofus2.protocol.messages.game.context.roleplay.death;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.state = reader.readSByte();
		if (state < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on state = %s, it doesn't respect the following condition : state < 0", state));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.state);
	}
}