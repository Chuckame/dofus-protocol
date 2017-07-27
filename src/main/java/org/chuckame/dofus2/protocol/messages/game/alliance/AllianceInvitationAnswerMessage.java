package org.chuckame.dofus2.protocol.messages.game.alliance;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AllianceInvitationAnswerMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6401;
	
	private boolean accept;
	
	public AllianceInvitationAnswerMessage() {
	}
	
	public AllianceInvitationAnswerMessage(boolean accept) {
		this.accept = accept;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.accept = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.accept);
	}
}