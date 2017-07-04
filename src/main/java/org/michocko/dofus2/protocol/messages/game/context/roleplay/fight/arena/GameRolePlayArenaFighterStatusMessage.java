package org.michocko.dofus2.protocol.messages.game.context.roleplay.fight.arena;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameRolePlayArenaFighterStatusMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6281;
	
	private int fightId;
	private int playerId;
	private boolean accepted;
	
	public GameRolePlayArenaFighterStatusMessage() {
	}
	
	public GameRolePlayArenaFighterStatusMessage(int fightId, int playerId, boolean accepted) {
		this.fightId = fightId;
		this.playerId = playerId;
		this.accepted = accepted;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightId = reader.readInt();
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		this.accepted = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.fightId);
		writer.writeInt(this.playerId);
		writer.writeBoolean(this.accepted);
	}
}