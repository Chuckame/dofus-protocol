package org.chuckame.dofus2.protocol.messages.game.context.roleplay.fight.arena;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameRolePlayArenaFightAnswerMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6279;
	
	private int fightId;
	private boolean accept;
	
	public GameRolePlayArenaFightAnswerMessage() {
	}
	
	public GameRolePlayArenaFightAnswerMessage(int fightId, boolean accept) {
		this.fightId = fightId;
		this.accept = accept;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightId = reader.readInt();
		this.accept = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.fightId);
		writer.writeBoolean(this.accept);
	}
}