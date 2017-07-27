package org.chuckame.dofus2.protocol.messages.game.guild;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildSpellUpgradeRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5699;
	
	private int spellId;
	
	public GuildSpellUpgradeRequestMessage() {
	}
	
	public GuildSpellUpgradeRequestMessage(int spellId) {
		this.spellId = spellId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.spellId = reader.readInt();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.spellId);
	}
}