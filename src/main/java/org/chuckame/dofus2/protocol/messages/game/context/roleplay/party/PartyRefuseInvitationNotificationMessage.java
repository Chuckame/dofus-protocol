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
public class PartyRefuseInvitationNotificationMessage extends AbstractPartyEventMessage {
	public static final int MESSAGE_ID = 5596;
	
	private int guestId;
	
	public PartyRefuseInvitationNotificationMessage() {
	}
	
	public PartyRefuseInvitationNotificationMessage(int partyId, int guestId) {
		super(partyId);
		this.guestId = guestId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.guestId = reader.readInt();
		if (guestId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on guestId = %s, it doesn't respect the following condition : guestId < 0", guestId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.guestId);
	}
}