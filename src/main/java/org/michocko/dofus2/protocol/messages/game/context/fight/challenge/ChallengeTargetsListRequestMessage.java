package org.michocko.dofus2.protocol.messages.game.context.fight.challenge;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ChallengeTargetsListRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5614;
	
	private short challengeId;
	
	public ChallengeTargetsListRequestMessage() {
	}
	
	public ChallengeTargetsListRequestMessage(short challengeId) {
		this.challengeId = challengeId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.challengeId = reader.readShort();
		if (challengeId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on challengeId = %s, it doesn't respect the following condition : challengeId < 0", challengeId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.challengeId);
	}
}