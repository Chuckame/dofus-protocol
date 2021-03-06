package org.chuckame.dofus2.protocol.messages.game.character.choice;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.character.choice.CharacterSelectedErrorMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class CharacterSelectedErrorMissingMapPackMessage extends CharacterSelectedErrorMessage {
	public static final int MESSAGE_ID = 6300;
	
	private int subAreaId;
	
	public CharacterSelectedErrorMissingMapPackMessage() {
	}
	
	public CharacterSelectedErrorMissingMapPackMessage(int subAreaId) {
		this.subAreaId = subAreaId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.subAreaId = reader.readInt();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.subAreaId);
	}
}