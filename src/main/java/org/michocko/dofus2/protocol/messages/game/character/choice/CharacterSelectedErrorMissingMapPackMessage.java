package org.michocko.dofus2.protocol.messages.game.character.choice;

import org.michocko.dofus2.protocol.messages.game.character.choice.CharacterSelectedErrorMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
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