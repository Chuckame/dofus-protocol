package org.michocko.dofus2.protocol.messages.game.context.roleplay.party;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.party.PartyMemberGeoPosition;
import org.michocko.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyLocateMembersMessage extends AbstractPartyMessage {
	public static final int MESSAGE_ID = 5595;
	
	private Collection<PartyMemberGeoPosition> geopositions;
	
	public PartyLocateMembersMessage() {
	}
	
	public PartyLocateMembersMessage(int partyId, Collection<PartyMemberGeoPosition> geopositions) {
		super(partyId);
		this.geopositions = geopositions;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.geopositions = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PartyMemberGeoPosition entry = new PartyMemberGeoPosition();
			entry.deserialize(reader);
			this.geopositions.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.geopositions.size());
		for (PartyMemberGeoPosition entry : this.geopositions)
		{
			entry.serialize(writer);
		}
	}
}