package org.chuckame.dofus2.protocol.messages.game.context.roleplay.party;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyEventMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyMemberRemoveMessage extends AbstractPartyEventMessage {
	public static final int MESSAGE_ID = 5579;
	
	private int leavingPlayerId;
	
	public PartyMemberRemoveMessage() {
	}
	
	public PartyMemberRemoveMessage(int partyId, int leavingPlayerId) {
		super(partyId);
		this.leavingPlayerId = leavingPlayerId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.leavingPlayerId = reader.readInt();
		if (leavingPlayerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on leavingPlayerId = %s, it doesn't respect the following condition : leavingPlayerId < 0", leavingPlayerId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.leavingPlayerId);
	}
}