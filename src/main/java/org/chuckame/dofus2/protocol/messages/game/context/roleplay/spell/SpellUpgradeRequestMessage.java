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
public class SpellUpgradeRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5608;
	
	private short spellId;
	private byte spellLevel;
	
	public SpellUpgradeRequestMessage() {
	}
	
	public SpellUpgradeRequestMessage(short spellId, byte spellLevel) {
		this.spellId = spellId;
		this.spellLevel = spellLevel;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.spellId = reader.readShort();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
		this.spellLevel = reader.readSByte();
		if (spellLevel < 1 || spellLevel > 6)
			throw new IllegalArgumentException(String.format("Forbidden value on spellLevel = %s, it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6", spellLevel));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.spellId);
		writer.writeSByte(this.spellLevel);
	}
}