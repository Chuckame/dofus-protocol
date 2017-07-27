package org.chuckame.dofus2.protocol.messages.game.context.fight.challenge;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ChallengeTargetUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6123;
	
	private short challengeId;
	private int targetId;
	
	public ChallengeTargetUpdateMessage() {
	}
	
	public ChallengeTargetUpdateMessage(short challengeId, int targetId) {
		this.challengeId = challengeId;
		this.targetId = targetId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.challengeId = reader.readShort();
		if (challengeId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on challengeId = %s, it doesn't respect the following condition : challengeId < 0", challengeId));
		this.targetId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.challengeId);
		writer.writeInt(this.targetId);
	}
}