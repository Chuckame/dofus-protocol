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
public class ChallengeInfoMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6022;
	
	private short challengeId;
	private int targetId;
	private int xpBonus;
	private int dropBonus;
	
	public ChallengeInfoMessage() {
	}
	
	public ChallengeInfoMessage(short challengeId, int targetId, int xpBonus, int dropBonus) {
		this.challengeId = challengeId;
		this.targetId = targetId;
		this.xpBonus = xpBonus;
		this.dropBonus = dropBonus;
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
		this.targetId = reader.readInt();
		this.xpBonus = reader.readInt();
		if (xpBonus < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on xpBonus = %s, it doesn't respect the following condition : xpBonus < 0", xpBonus));
		this.dropBonus = reader.readInt();
		if (dropBonus < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dropBonus = %s, it doesn't respect the following condition : dropBonus < 0", dropBonus));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.challengeId);
		writer.writeInt(this.targetId);
		writer.writeInt(this.xpBonus);
		writer.writeInt(this.dropBonus);
	}
}