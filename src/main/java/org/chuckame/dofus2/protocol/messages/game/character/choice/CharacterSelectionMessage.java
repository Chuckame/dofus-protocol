package org.chuckame.dofus2.protocol.messages.game.character.choice;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CharacterSelectionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 152;
	
	private int id;
	
	public CharacterSelectionMessage() {
	}
	
	public CharacterSelectionMessage(int id) {
		this.id = id;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
		if (id < 1 || id > 2147483647)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 1 || id > 2147483647", id));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
	}
}