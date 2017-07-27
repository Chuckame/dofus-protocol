package org.chuckame.dofus2.protocol.messages.game.context.roleplay.party;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.party.PartyInvitationMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyInvitationDungeonMessage extends PartyInvitationMessage {
	public static final int MESSAGE_ID = 6244;
	
	private short dungeonId;
	
	public PartyInvitationDungeonMessage() {
	}
	
	public PartyInvitationDungeonMessage(int partyId, byte partyType, byte maxParticipants, int fromId, String fromName, int toId, short dungeonId) {
		super(partyId, partyType, maxParticipants, fromId, fromName, toId);
		this.dungeonId = dungeonId;
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
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.dungeonId);
	}
}