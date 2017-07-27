package org.chuckame.dofus2.protocol.messages.game.character.stats;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.character.stats.CharacterLevelUpMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class CharacterLevelUpInformationMessage extends CharacterLevelUpMessage {
	public static final int MESSAGE_ID = 6076;
	
	private String name;
	private int id;
	
	public CharacterLevelUpInformationMessage() {
	}
	
	public CharacterLevelUpInformationMessage(short newLevel, String name, int id) {
		super(newLevel);
		this.name = name;
		this.id = id;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.name = reader.readUTF();
		this.id = reader.readInt();
		if (id < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0", id));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.name);
		writer.writeInt(this.id);
	}
}