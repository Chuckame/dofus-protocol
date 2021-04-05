package org.michocko.dofus2.protocol.messages.game.context.roleplay;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.fightCount = reader.readShort();
		if (fightCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightCount = %s, it doesn't respect the following condition : fightCount < 0", fightCount));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.fightCount);
	}
}