package org.michocko.dofus2.protocol.messages.game.context.roleplay.party;

import org.michocko.dofus2.protocol.types.game.context.roleplay.party.PartyGuestInformations;
import org.michocko.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyEventMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyNewGuestMessage extends AbstractPartyEventMessage {
	public static final int MESSAGE_ID = 6260;
	
	private PartyGuestInformations guest;
	
	public PartyNewGuestMessage() {
	}
	
	public PartyNewGuestMessage(int partyId, PartyGuestInformations guest) {
		super(partyId);
		this.guest = guest;
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
		this.guest = new PartyGuestInformations();
		this.guest.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.guest.serialize(writer);
	}
}