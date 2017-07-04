package org.michocko.dofus2.protocol.messages.game.interactive;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class InteractiveUseRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5001;
	
	private int elemId;
	private int skillInstanceUid;
	
	public InteractiveUseRequestMessage() {
	}
	
	public InteractiveUseRequestMessage(int elemId, int skillInstanceUid) {
		this.elemId = elemId;
		this.skillInstanceUid = skillInstanceUid;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.elemId = reader.readInt();
		if (elemId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on elemId = %s, it doesn't respect the following condition : elemId < 0", elemId));
		this.skillInstanceUid = reader.readInt();
		if (skillInstanceUid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skillInstanceUid = %s, it doesn't respect the following condition : skillInstanceUid < 0", skillInstanceUid));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.elemId);
		writer.writeInt(this.skillInstanceUid);
	}
}