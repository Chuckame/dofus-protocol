package org.chuckame.dofus2.protocol.messages.game.context.roleplay.spell;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SpellItemBoostMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6011;
	
	private int statId;
	private short spellId;
	private short value;
	
	public SpellItemBoostMessage() {
	}
	
	public SpellItemBoostMessage(int statId, short spellId, short value) {
		this.statId = statId;
		this.spellId = spellId;
		this.value = value;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.statId = reader.readInt();
		if (statId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on statId = %s, it doesn't respect the following condition : statId < 0", statId));
		this.spellId = reader.readShort();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
		this.value = reader.readShort();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.statId);
		writer.writeShort(this.spellId);
		writer.writeShort(this.value);
	}
}