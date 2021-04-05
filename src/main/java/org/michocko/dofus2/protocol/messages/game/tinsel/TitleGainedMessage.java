package org.michocko.dofus2.protocol.messages.game.tinsel;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TitleGainedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6364;
	
	private short titleId;
	
	public TitleGainedMessage() {
	}
	
	public TitleGainedMessage(short titleId) {
		this.titleId = titleId;
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
		this.titleId = reader.readShort();
		if (titleId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on titleId = %s, it doesn't respect the following condition : titleId < 0", titleId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.titleId);
	}
}