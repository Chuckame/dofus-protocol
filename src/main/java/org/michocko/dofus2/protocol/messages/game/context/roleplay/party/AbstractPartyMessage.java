package org.michocko.dofus2.protocol.messages.game.context.roleplay.party;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AbstractPartyMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6274;
	
	private int partyId;
	
	public AbstractPartyMessage() {
	}
	
	public AbstractPartyMessage(int partyId) {
		this.partyId = partyId;
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
		this.partyId = reader.readInt();
		if (partyId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on partyId = %s, it doesn't respect the following condition : partyId < 0", partyId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.partyId);
	}
}