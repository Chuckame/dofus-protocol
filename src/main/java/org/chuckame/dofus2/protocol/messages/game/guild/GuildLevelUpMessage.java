package org.chuckame.dofus2.protocol.messages.game.guild;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.newLevel = reader.readByte();
		if (newLevel < 2 || newLevel > 200)
			throw new IllegalArgumentException(String.format("Forbidden value on newLevel = %s, it doesn't respect the following condition : newLevel < 2 || newLevel > 200", newLevel));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeByte(this.newLevel);
	}
}