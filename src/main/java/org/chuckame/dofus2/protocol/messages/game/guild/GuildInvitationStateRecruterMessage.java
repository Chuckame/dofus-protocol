package org.chuckame.dofus2.protocol.messages.game.guild;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildInvitationStateRecruterMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5563;
	
	private String recrutedName;
	private byte invitationState;
	
	public GuildInvitationStateRecruterMessage() {
	}
	
	public GuildInvitationStateRecruterMessage(String recrutedName, byte invitationState) {
		this.recrutedName = recrutedName;
		this.invitationState = invitationState;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.recrutedName = reader.readUTF();
		this.invitationState = reader.readSByte();
		if (invitationState < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on invitationState = %s, it doesn't respect the following condition : invitationState < 0", invitationState));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.recrutedName);
		writer.writeSByte(this.invitationState);
	}
}