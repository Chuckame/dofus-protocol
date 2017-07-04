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
public class PartyPledgeLoyaltyRequestMessage extends AbstractPartyMessage {
	public static final int MESSAGE_ID = 6269;
	
	private boolean loyal;
	
	public PartyPledgeLoyaltyRequestMessage() {
	}
	
	public PartyPledgeLoyaltyRequestMessage(int partyId, boolean loyal) {
		super(partyId);
		this.loyal = loyal;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.loyal = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeBoolean(this.loyal);
	}
}