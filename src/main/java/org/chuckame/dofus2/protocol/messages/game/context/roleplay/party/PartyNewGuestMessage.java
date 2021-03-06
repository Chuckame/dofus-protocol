package org.chuckame.dofus2.protocol.messages.game.context.roleplay.party;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyEventMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.party.PartyGuestInformations;

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
	public int getProtocolId() {
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