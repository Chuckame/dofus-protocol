package org.chuckame.dofus2.protocol.messages.game.actions.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameActionFightNoSpellCastMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6132;
	
	private int spellLevelId;
	
	public GameActionFightNoSpellCastMessage() {
	}
	
	public GameActionFightNoSpellCastMessage(int spellLevelId) {
		this.spellLevelId = spellLevelId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.spellLevelId = reader.readInt();
		if (spellLevelId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellLevelId = %s, it doesn't respect the following condition : spellLevelId < 0", spellLevelId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.spellLevelId);
	}
}