package org.michocko.dofus2.protocol.messages.game.packs;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PackRestrictedSubAreaMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6186;
	
	private int subAreaId;
	
	public PackRestrictedSubAreaMessage() {
	}
	
	public PackRestrictedSubAreaMessage(int subAreaId) {
		this.subAreaId = subAreaId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.subAreaId = reader.readInt();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.subAreaId);
	}
}