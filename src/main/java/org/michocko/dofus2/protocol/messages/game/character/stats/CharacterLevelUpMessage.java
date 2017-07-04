package org.michocko.dofus2.protocol.messages.game.character.stats;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CharacterLevelUpMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5670;
	
	private short newLevel;
	
	public CharacterLevelUpMessage() {
	}
	
	public CharacterLevelUpMessage(short newLevel) {
		this.newLevel = newLevel;
	}
	
	public int getNetworkMessageId() {
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