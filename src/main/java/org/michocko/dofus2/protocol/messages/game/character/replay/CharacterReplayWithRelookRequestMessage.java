package org.michocko.dofus2.protocol.messages.game.character.replay;

import org.michocko.dofus2.protocol.messages.game.character.replay.CharacterReplayRequestMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class CharacterReplayWithRelookRequestMessage extends CharacterReplayRequestMessage {
	public static final int MESSAGE_ID = 6354;
	
	private int cosmeticId;
	
	public CharacterReplayWithRelookRequestMessage() {
	}
	
	public CharacterReplayWithRelookRequestMessage(int characterId, int cosmeticId) {
		super(characterId);
		this.cosmeticId = cosmeticId;
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
		this.cosmeticId = reader.readInt();
		if (cosmeticId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on cosmeticId = %s, it doesn't respect the following condition : cosmeticId < 0", cosmeticId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.cosmeticId);
	}
}