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
public class GameRolePlayPlayerFightFriendlyRequestedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5937;
	
	private int fightId;
	private int sourceId;
	private int targetId;
	
	public GameRolePlayPlayerFightFriendlyRequestedMessage() {
	}
	
	public GameRolePlayPlayerFightFriendlyRequestedMessage(int fightId, int sourceId, int targetId) {
		this.fightId = fightId;
		this.sourceId = sourceId;
		this.targetId = targetId;
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
		this.fightId = reader.readInt();
		if (fightId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightId = %s, it doesn't respect the following condition : fightId < 0", fightId));
		this.sourceId = reader.readInt();
		if (sourceId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on sourceId = %s, it doesn't respect the following condition : sourceId < 0", sourceId));
		this.targetId = reader.readInt();
		if (targetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on targetId = %s, it doesn't respect the following condition : targetId < 0", targetId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.fightId);
		writer.writeInt(this.sourceId);
		writer.writeInt(this.targetId);
	}
}