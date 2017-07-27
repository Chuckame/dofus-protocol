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
public class PartyKickedByMessage extends AbstractPartyMessage {
	public static final int MESSAGE_ID = 5590;
	
	private int kickerId;
	
	public PartyKickedByMessage() {
	}
	
	public PartyKickedByMessage(int partyId, int kickerId) {
		super(partyId);
		this.kickerId = kickerId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.kickerId = reader.readInt();
		if (kickerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on kickerId = %s, it doesn't respect the following condition : kickerId < 0", kickerId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.kickerId);
	}
}