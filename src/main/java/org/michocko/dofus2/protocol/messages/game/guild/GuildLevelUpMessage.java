package org.michocko.dofus2.protocol.messages.game.guild;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildLevelUpMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6062;
	
	private short newLevel;
	
	public GuildLevelUpMessage() {
	}
	
	public GuildLevelUpMessage(short newLevel) {
		this.newLevel = newLevel;
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
		this.newLevel = reader.readByte();
		if (newLevel < 2 || newLevel > 200)
			throw new IllegalArgumentException(String.format("Forbidden value on newLevel = %s, it doesn't respect the following condition : newLevel < 2 || newLevel > 200", newLevel));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeByte(this.newLevel);
	}
}