package org.michocko.dofus2.protocol.messages.game.context.roleplay.party;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.party.PartyMemberInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.party.PartyGuestInformations;
import org.michocko.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyMessage;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyJoinMessage extends AbstractPartyMessage {
	public static final int MESSAGE_ID = 5576;
	
	private byte partyType;
	private int partyLeaderId;
	private byte maxParticipants;
	private Collection<PartyMemberInformations> members;
	private Collection<PartyGuestInformations> guests;
	private boolean restricted;
	
	public PartyJoinMessage() {
	}
	
	public PartyJoinMessage(int partyId, byte partyType, int partyLeaderId, byte maxParticipants, Collection<PartyMemberInformations> members, Collection<PartyGuestInformations> guests, boolean restricted) {
		super(partyId);
		this.partyType = partyType;
		this.partyLeaderId = partyLeaderId;
		this.maxParticipants = maxParticipants;
		this.members = members;
		this.guests = guests;
		this.restricted = restricted;
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
		this.partyType = reader.readSByte();
		if (partyType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on partyType = %s, it doesn't respect the following condition : partyType < 0", partyType));
		this.partyLeaderId = reader.readInt();
		if (partyLeaderId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on partyLeaderId = %s, it doesn't respect the following condition : partyLeaderId < 0", partyLeaderId));
		this.maxParticipants = reader.readSByte();
		if (maxParticipants < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxParticipants = %s, it doesn't respect the following condition : maxParticipants < 0", maxParticipants));
		int length = reader.readUShort();
		this.members = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PartyMemberInformations entry = (PartyMemberInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
			entry.deserialize(reader);
			this.members.add(entry);
		}
		length = reader.readUShort();
		this.guests = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PartyGuestInformations entry = new PartyGuestInformations();
			entry.deserialize(reader);
			this.guests.add(entry);
		}
		this.restricted = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.partyType);
		writer.writeInt(this.partyLeaderId);
		writer.writeSByte(this.maxParticipants);
		writer.writeUShort(this.members.size());
		for (PartyMemberInformations entry : this.members)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
		writer.writeUShort(this.guests.size());
		for (PartyGuestInformations entry : this.guests)
		{
			entry.serialize(writer);
		}
		writer.writeBoolean(this.restricted);
	}
}