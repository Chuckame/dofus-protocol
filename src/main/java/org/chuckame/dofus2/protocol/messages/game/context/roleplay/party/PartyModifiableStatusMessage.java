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
public class PartyModifiableStatusMessage extends AbstractPartyMessage {
	public static final int MESSAGE_ID = 6277;
	
	private boolean enabled;
	
	public PartyModifiableStatusMessage() {
	}
	
	public PartyModifiableStatusMessage(int partyId, boolean enabled) {
		super(partyId);
		this.enabled = enabled;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.enabled = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeBoolean(this.enabled);
	}
}