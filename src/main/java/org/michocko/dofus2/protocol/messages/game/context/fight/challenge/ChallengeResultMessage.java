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
public class ChallengeResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6019;
	
	private short challengeId;
	private boolean success;
	
	public ChallengeResultMessage() {
	}
	
	public ChallengeResultMessage(short challengeId, boolean success) {
		this.challengeId = challengeId;
		this.success = success;
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
		this.challengeId = reader.readShort();
		if (challengeId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on challengeId = %s, it doesn't respect the following condition : challengeId < 0", challengeId));
		this.success = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.challengeId);
		writer.writeBoolean(this.success);
	}
}