package org.michocko.dofus2.protocol.messages.game.actions.fight;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.spellLevelId = reader.readInt();
		if (spellLevelId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellLevelId = %s, it doesn't respect the following condition : spellLevelId < 0", spellLevelId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.spellLevelId);
	}
}