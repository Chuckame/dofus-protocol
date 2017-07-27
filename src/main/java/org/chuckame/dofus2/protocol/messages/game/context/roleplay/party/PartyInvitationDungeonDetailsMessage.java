package org.chuckame.dofus2.protocol.messages.game.context.roleplay.party;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.party.PartyInvitationDetailsMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.party.PartyGuestInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.party.PartyInvitationMemberInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyInvitationDungeonDetailsMessage extends PartyInvitationDetailsMessage {
	public static final int MESSAGE_ID = 6262;
	
	private short dungeonId;
	private Collection<Boolean> playersDungeonReady;
	
	public PartyInvitationDungeonDetailsMessage() {
	}
	
	public PartyInvitationDungeonDetailsMessage(int partyId, byte partyType, int fromId, String fromName, int leaderId, Collection<PartyInvitationMemberInformations> members, Collection<PartyGuestInformations> guests, short dungeonId, Collection<Boolean> playersDungeonReady) {
		super(partyId, partyType, fromId, fromName, leaderId, members, guests);
		this.dungeonId = dungeonId;
		this.playersDungeonReady = playersDungeonReady;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.dungeonId = reader.readShort();
		if (dungeonId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dungeonId = %s, it doesn't respect the following condition : dungeonId < 0", dungeonId));
		int length = reader.readUShort();
		this.playersDungeonReady = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			boolean entry = reader.readBoolean();
			this.playersDungeonReady.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.dungeonId);
		writer.writeUShort(this.playersDungeonReady.size());
		for (boolean entry : this.playersDungeonReady)
		{
			writer.writeBoolean(entry);
		}
	}
}