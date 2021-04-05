package org.michocko.dofus2.protocol.messages.game.context.roleplay.party;

import org.michocko.dofus2.protocol.types.game.context.roleplay.party.PartyMemberInformations;
import org.michocko.dofus2.protocol.messages.game.context.roleplay.party.PartyUpdateMessage;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyNewMemberMessage extends PartyUpdateMessage {
	public static final int MESSAGE_ID = 6306;
	
	
	public PartyNewMemberMessage() {
	}
	
	public PartyNewMemberMessage(int partyId, PartyMemberInformations memberInformations) {
		super(partyId, memberInformations);
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
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}