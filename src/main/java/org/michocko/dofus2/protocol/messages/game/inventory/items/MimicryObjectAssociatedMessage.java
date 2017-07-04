package org.michocko.dofus2.protocol.messages.game.inventory.items;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MimicryObjectAssociatedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6462;
	
	private int hostUID;
	
	public MimicryObjectAssociatedMessage() {
	}
	
	public MimicryObjectAssociatedMessage(int hostUID) {
		this.hostUID = hostUID;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.hostUID = reader.readInt();
		if (hostUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on hostUID = %s, it doesn't respect the following condition : hostUID < 0", hostUID));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.hostUID);
	}
}