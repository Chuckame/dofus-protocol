package org.chuckame.dofus2.protocol.messages.game.context.roleplay.party;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyEventMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyCancelInvitationNotificationMessage extends AbstractPartyEventMessage {
	public static final int MESSAGE_ID = 6251;
	
	private int cancelerId;
	private int guestId;
	
	public PartyCancelInvitationNotificationMessage() {
	}
	
	public PartyCancelInvitationNotificationMessage(int partyId, int cancelerId, int guestId) {
		super(partyId);
		this.cancelerId = cancelerId;
		this.guestId = guestId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.cancelerId = reader.readInt();
		if (cancelerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on cancelerId = %s, it doesn't respect the following condition : cancelerId < 0", cancelerId));
		this.guestId = reader.readInt();
		if (guestId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on guestId = %s, it doesn't respect the following condition : guestId < 0", guestId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.cancelerId);
		writer.writeInt(this.guestId);
	}
}