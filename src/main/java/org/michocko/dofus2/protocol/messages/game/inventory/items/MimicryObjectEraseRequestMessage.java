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
public class MimicryObjectEraseRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6457;
	
	private int hostUID;
	private short hostPos;
	
	public MimicryObjectEraseRequestMessage() {
	}
	
	public MimicryObjectEraseRequestMessage(int hostUID, short hostPos) {
		this.hostUID = hostUID;
		this.hostPos = hostPos;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.hostUID = reader.readInt();
		if (hostUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on hostUID = %s, it doesn't respect the following condition : hostUID < 0", hostUID));
		this.hostPos = reader.readByte();
		if (hostPos < 0 || hostPos > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on hostPos = %s, it doesn't respect the following condition : hostPos < 0 || hostPos > 255", hostPos));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.hostUID);
		writer.writeByte(this.hostPos);
	}
}