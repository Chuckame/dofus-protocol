package org.michocko.dofus2.protocol.messages.game.chat.channel;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ChannelEnablingMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 890;
	
	private byte channel;
	private boolean enable;
	
	public ChannelEnablingMessage() {
	}
	
	public ChannelEnablingMessage(byte channel, boolean enable) {
		this.channel = channel;
		this.enable = enable;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.channel = reader.readSByte();
		if (channel < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on channel = %s, it doesn't respect the following condition : channel < 0", channel));
		this.enable = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.channel);
		writer.writeBoolean(this.enable);
	}
}