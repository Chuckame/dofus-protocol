package org.chuckame.dofus2.protocol.messages.game.context.roleplay.party;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyEventMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.party.PartyMemberInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyUpdateMessage extends AbstractPartyEventMessage {
	public static final int MESSAGE_ID = 5575;
	
	private PartyMemberInformations memberInformations;
	
	public PartyUpdateMessage() {
	}
	
	public PartyUpdateMessage(int partyId, PartyMemberInformations memberInformations) {
		super(partyId);
		this.memberInformations = memberInformations;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.memberInformations = ProtocolTypeManager.getInstance().<PartyMemberInformations>newInstance(reader.readShort());
		this.memberInformations.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.memberInformations.getProtocolTypeId());
		this.memberInformations.serialize(writer);
	}
}