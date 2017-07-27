package org.chuckame.dofus2.protocol.messages.game.context.roleplay.party;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.party.PartyGuestInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.party.PartyInvitationMemberInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyInvitationDetailsMessage extends AbstractPartyMessage {
	public static final int MESSAGE_ID = 6263;
	
	private byte partyType;
	private int fromId;
	private String fromName;
	private int leaderId;
	private Collection<PartyInvitationMemberInformations> members;
	private Collection<PartyGuestInformations> guests;
	
	public PartyInvitationDetailsMessage() {
	}
	
	public PartyInvitationDetailsMessage(int partyId, byte partyType, int fromId, String fromName, int leaderId, Collection<PartyInvitationMemberInformations> members, Collection<PartyGuestInformations> guests) {
		super(partyId);
		this.partyType = partyType;
		this.fromId = fromId;
		this.fromName = fromName;
		this.leaderId = leaderId;
		this.members = members;
		this.guests = guests;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.partyType = reader.readSByte();
		if (partyType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on partyType = %s, it doesn't respect the following condition : partyType < 0", partyType));
		this.fromId = reader.readInt();
		if (fromId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fromId = %s, it doesn't respect the following condition : fromId < 0", fromId));
		this.fromName = reader.readUTF();
		this.leaderId = reader.readInt();
		if (leaderId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on leaderId = %s, it doesn't respect the following condition : leaderId < 0", leaderId));
		int length = reader.readUShort();
		this.members = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PartyInvitationMemberInformations entry = new PartyInvitationMemberInformations();
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
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.partyType);
		writer.writeInt(this.fromId);
		writer.writeUTF(this.fromName);
		writer.writeInt(this.leaderId);
		writer.writeUShort(this.members.size());
		for (PartyInvitationMemberInformations entry : this.members)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.guests.size());
		for (PartyGuestInformations entry : this.guests)
		{
			entry.serialize(writer);
		}
	}
}