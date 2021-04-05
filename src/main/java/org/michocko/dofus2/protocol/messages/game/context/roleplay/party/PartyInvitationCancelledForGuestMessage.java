package org.michocko.dofus2.protocol.messages.game.context.roleplay.party;

import org.michocko.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyInvitationCancelledForGuestMessage extends AbstractPartyMessage {
	public static final int MESSAGE_ID = 6256;
	
	private int cancelerId;
	
	public PartyInvitationCancelledForGuestMessage() {
	}
	
	public PartyInvitationCancelledForGuestMessage(int partyId, int cancelerId) {
		super(partyId);
		this.cancelerId = cancelerId;
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
		super.deserialize(reader);
		this.cancelerId = reader.readInt();
		if (cancelerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on cancelerId = %s, it doesn't respect the following condition : cancelerId < 0", cancelerId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.cancelerId);
	}
}