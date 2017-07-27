package org.chuckame.dofus2.protocol.messages.game.chat.channel;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ChannelEnablingChangeMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 891;
	
	private byte channel;
	private boolean enable;
	
	public ChannelEnablingChangeMessage() {
	}
	
	public ChannelEnablingChangeMessage(byte channel, boolean enable) {
		this.channel = channel;
		this.enable = enable;
	}
	
	public int getProtocolId() {
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