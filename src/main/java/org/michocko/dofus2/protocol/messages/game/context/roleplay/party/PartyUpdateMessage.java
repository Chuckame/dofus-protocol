package org.michocko.dofus2.protocol.messages.game.context.roleplay.party;

import org.michocko.dofus2.protocol.types.game.context.roleplay.party.PartyMemberInformations;
import org.michocko.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyEventMessage;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.memberInformations = (PartyMemberInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
		this.memberInformations.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.memberInformations.getNetworkTypeId());
		this.memberInformations.serialize(writer);
	}
}