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
public class PartyInvitationMessage extends AbstractPartyMessage {
	public static final int MESSAGE_ID = 5586;
	
	private byte partyType;
	private byte maxParticipants;
	private int fromId;
	private String fromName;
	private int toId;
	
	public PartyInvitationMessage() {
	}
	
	public PartyInvitationMessage(int partyId, byte partyType, byte maxParticipants, int fromId, String fromName, int toId) {
		super(partyId);
		this.partyType = partyType;
		this.maxParticipants = maxParticipants;
		this.fromId = fromId;
		this.fromName = fromName;
		this.toId = toId;
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
		this.maxParticipants = reader.readSByte();
		if (maxParticipants < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxParticipants = %s, it doesn't respect the following condition : maxParticipants < 0", maxParticipants));
		this.fromId = reader.readInt();
		if (fromId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fromId = %s, it doesn't respect the following condition : fromId < 0", fromId));
		this.fromName = reader.readUTF();
		this.toId = reader.readInt();
		if (toId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on toId = %s, it doesn't respect the following condition : toId < 0", toId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.partyType);
		writer.writeSByte(this.maxParticipants);
		writer.writeInt(this.fromId);
		writer.writeUTF(this.fromName);
		writer.writeInt(this.toId);
	}
}