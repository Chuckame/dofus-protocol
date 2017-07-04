package org.michocko.dofus2.protocol.messages.game.context.roleplay.spell;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SpellUpgradeSuccessMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1201;
	
	private int spellId;
	private byte spellLevel;
	
	public SpellUpgradeSuccessMessage() {
	}
	
	public SpellUpgradeSuccessMessage(int spellId, byte spellLevel) {
		this.spellId = spellId;
		this.spellLevel = spellLevel;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.spellId = reader.readInt();
		this.spellLevel = reader.readSByte();
		if (spellLevel < 1 || spellLevel > 6)
			throw new IllegalArgumentException(String.format("Forbidden value on spellLevel = %s, it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6", spellLevel));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.spellId);
		writer.writeSByte(this.spellLevel);
	}
}