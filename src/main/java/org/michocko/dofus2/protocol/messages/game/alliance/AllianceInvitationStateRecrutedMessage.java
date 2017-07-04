package org.michocko.dofus2.protocol.messages.game.alliance;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AllianceInvitationStateRecrutedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6392;
	
	private byte invitationState;
	
	public AllianceInvitationStateRecrutedMessage() {
	}
	
	public AllianceInvitationStateRecrutedMessage(byte invitationState) {
		this.invitationState = invitationState;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.invitationState = reader.readSByte();
		if (invitationState < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on invitationState = %s, it doesn't respect the following condition : invitationState < 0", invitationState));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.invitationState);
	}
}