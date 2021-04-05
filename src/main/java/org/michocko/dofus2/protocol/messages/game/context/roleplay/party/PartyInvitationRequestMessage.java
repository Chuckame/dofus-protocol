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
public class PartyInvitationRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5585;
	
	private String name;
	
	public PartyInvitationRequestMessage() {
	}
	
	public PartyInvitationRequestMessage(String name) {
		this.name = name;
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
		this.name = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.name);
	}
}