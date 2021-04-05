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
public class GameRolePlayPlayerFightFriendlyAnsweredMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5733;
	
	private int fightId;
	private int sourceId;
	private int targetId;
	private boolean accept;
	
	public GameRolePlayPlayerFightFriendlyAnsweredMessage() {
	}
	
	public GameRolePlayPlayerFightFriendlyAnsweredMessage(int fightId, int sourceId, int targetId, boolean accept) {
		this.fightId = fightId;
		this.sourceId = sourceId;
		this.targetId = targetId;
		this.accept = accept;
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
		this.sourceId = reader.readInt();
		if (sourceId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on sourceId = %s, it doesn't respect the following condition : sourceId < 0", sourceId));
		this.targetId = reader.readInt();
		if (targetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on targetId = %s, it doesn't respect the following condition : targetId < 0", targetId));
		this.accept = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.fightId);
		writer.writeInt(this.sourceId);
		writer.writeInt(this.targetId);
		writer.writeBoolean(this.accept);
	}
}