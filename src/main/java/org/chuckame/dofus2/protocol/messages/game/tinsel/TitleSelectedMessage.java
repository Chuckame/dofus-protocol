package org.chuckame.dofus2.protocol.messages.game.tinsel;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TitleSelectedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6366;
	
	private short titleId;
	
	public TitleSelectedMessage() {
	}
	
	public TitleSelectedMessage(short titleId) {
		this.titleId = titleId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.titleId = reader.readShort();
		if (titleId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on titleId = %s, it doesn't respect the following condition : titleId < 0", titleId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.titleId);
	}
}