package org.michocko.dofus2.protocol.messages.game.guild;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.spellId = reader.readInt();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.spellId);
	}
}