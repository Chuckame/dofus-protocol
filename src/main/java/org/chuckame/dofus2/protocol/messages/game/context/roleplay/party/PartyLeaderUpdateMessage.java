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
public class PartyLeaderUpdateMessage extends AbstractPartyEventMessage {
	public static final int MESSAGE_ID = 5578;
	
	private int partyLeaderId;
	
	public PartyLeaderUpdateMessage() {
	}
	
	public PartyLeaderUpdateMessage(int partyId, int partyLeaderId) {
		super(partyId);
		this.partyLeaderId = partyLeaderId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.partyLeaderId = reader.readInt();
		if (partyLeaderId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on partyLeaderId = %s, it doesn't respect the following condition : partyLeaderId < 0", partyLeaderId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.partyLeaderId);
	}
}