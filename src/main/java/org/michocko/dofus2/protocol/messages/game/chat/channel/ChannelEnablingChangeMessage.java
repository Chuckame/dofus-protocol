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
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.channel = reader.readSByte();
		if (channel < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on channel = %s, it doesn't respect the following condition : channel < 0", channel));
		this.enable = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.channel);
		writer.writeBoolean(this.enable);
	}
}