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
public class AllianceInvitationMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6395;
	
	private int targetId;
	
	public AllianceInvitationMessage() {
	}
	
	public AllianceInvitationMessage(int targetId) {
		this.targetId = targetId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.targetId = reader.readInt();
		if (targetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on targetId = %s, it doesn't respect the following condition : targetId < 0", targetId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.targetId);
	}
}