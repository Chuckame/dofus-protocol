package org.michocko.dofus2.protocol.messages.game.context.roleplay.fight;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.attackerId = reader.readInt();
		if (attackerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on attackerId = %s, it doesn't respect the following condition : attackerId < 0", attackerId));
		this.defenderId = reader.readInt();
		if (defenderId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on defenderId = %s, it doesn't respect the following condition : defenderId < 0", defenderId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.attackerId);
		writer.writeInt(this.defenderId);
	}
}