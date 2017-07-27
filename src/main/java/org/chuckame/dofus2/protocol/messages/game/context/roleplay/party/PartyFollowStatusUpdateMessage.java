package org.chuckame.dofus2.protocol.messages.game.context.roleplay.party;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyFollowStatusUpdateMessage extends AbstractPartyMessage {
	public static final int MESSAGE_ID = 5581;
	
	private boolean success;
	private int followedId;
	
	public PartyFollowStatusUpdateMessage() {
	}
	
	public PartyFollowStatusUpdateMessage(int partyId, boolean success, int followedId) {
		super(partyId);
		this.success = success;
		this.followedId = followedId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.success = reader.readBoolean();
		this.followedId = reader.readInt();
		if (followedId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on followedId = %s, it doesn't respect the following condition : followedId < 0", followedId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeBoolean(this.success);
		writer.writeInt(this.followedId);
	}
}