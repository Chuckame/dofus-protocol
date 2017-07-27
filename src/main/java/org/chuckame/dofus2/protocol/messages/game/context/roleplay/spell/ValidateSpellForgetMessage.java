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
public class ValidateSpellForgetMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1700;
	
	private short spellId;
	
	public ValidateSpellForgetMessage() {
	}
	
	public ValidateSpellForgetMessage(short spellId) {
		this.spellId = spellId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.spellId = reader.readShort();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.spellId);
	}
}