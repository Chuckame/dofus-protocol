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
public class GameRolePlayRemoveChallengeMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 300;
	
	private int fightId;
	
	public GameRolePlayRemoveChallengeMessage() {
	}
	
	public GameRolePlayRemoveChallengeMessage(int fightId) {
		this.fightId = fightId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.fightId);
	}
}