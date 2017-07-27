package org.chuckame.dofus2.protocol.messages.game.context.roleplay.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameRolePlayAggressionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6073;
	
	private int attackerId;
	private int defenderId;
	
	public GameRolePlayAggressionMessage() {
	}
	
	public GameRolePlayAggressionMessage(int attackerId, int defenderId) {
		this.attackerId = attackerId;
		this.defenderId = defenderId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.attackerId = reader.readInt();
		if (attackerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on attackerId = %s, it doesn't respect the following condition : attackerId < 0", attackerId));
		this.defenderId = reader.readInt();
		if (defenderId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on defenderId = %s, it doesn't respect the following condition : defenderId < 0", defenderId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.attackerId);
		writer.writeInt(this.defenderId);
	}
}