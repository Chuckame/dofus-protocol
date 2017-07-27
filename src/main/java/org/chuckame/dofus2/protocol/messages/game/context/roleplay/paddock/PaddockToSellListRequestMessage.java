package org.chuckame.dofus2.protocol.messages.game.context.roleplay.paddock;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PaddockToSellListRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6141;
	
	private short pageIndex;
	
	public PaddockToSellListRequestMessage() {
	}
	
	public PaddockToSellListRequestMessage(short pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.pageIndex = reader.readShort();
		if (pageIndex < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on pageIndex = %s, it doesn't respect the following condition : pageIndex < 0", pageIndex));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.pageIndex);
	}
}