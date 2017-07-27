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
public class GameRolePlayPlayerFightFriendlyAnswerMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5732;
	
	private int fightId;
	private boolean accept;
	
	public GameRolePlayPlayerFightFriendlyAnswerMessage() {
	}
	
	public GameRolePlayPlayerFightFriendlyAnswerMessage(int fightId, boolean accept) {
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