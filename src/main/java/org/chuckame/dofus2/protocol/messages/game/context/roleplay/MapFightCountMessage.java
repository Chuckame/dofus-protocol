package org.chuckame.dofus2.protocol.messages.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MapFightCountMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 210;
	
	private short fightCount;
	
	public MapFightCountMessage() {
	}
	
	public MapFightCountMessage(short fightCount) {
		this.fightCount = fightCount;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightCount = reader.readShort();
		if (fightCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightCount = %s, it doesn't respect the following condition : fightCount < 0", fightCount));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.fightCount);
	}
}