package org.michocko.dofus2.protocol.messages.game.inventory.items;

import org.michocko.dofus2.protocol.messages.game.inventory.items.ObjectUseMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ObjectUseOnCharacterMessage extends ObjectUseMessage {
	public static final int MESSAGE_ID = 3003;
	
	private int characterId;
	
	public ObjectUseOnCharacterMessage() {
	}
	
	public ObjectUseOnCharacterMessage(int objectUID, int characterId) {
		super(objectUID);
		this.characterId = characterId;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.characterId = reader.readInt();
		if (characterId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on characterId = %s, it doesn't respect the following condition : characterId < 0", characterId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.characterId);
	}
}