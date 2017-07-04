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
public class InteractiveUseEndedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6112;
	
	private int elemId;
	private short skillId;
	
	public InteractiveUseEndedMessage() {
	}
	
	public InteractiveUseEndedMessage(int elemId, short skillId) {
		this.elemId = elemId;
		this.skillId = skillId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.elemId = reader.readInt();
		if (elemId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on elemId = %s, it doesn't respect the following condition : elemId < 0", elemId));
		this.skillId = reader.readShort();
		if (skillId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skillId = %s, it doesn't respect the following condition : skillId < 0", skillId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.elemId);
		writer.writeShort(this.skillId);
	}
}