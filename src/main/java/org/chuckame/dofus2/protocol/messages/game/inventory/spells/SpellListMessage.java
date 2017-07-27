package org.chuckame.dofus2.protocol.messages.game.inventory.spells;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.SpellItem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SpellListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1200;
	
	private boolean spellPrevisualization;
	private Collection<SpellItem> spells;
	
	public SpellListMessage() {
	}
	
	public SpellListMessage(boolean spellPrevisualization, Collection<SpellItem> spells) {
		this.spellPrevisualization = spellPrevisualization;
		this.spells = spells;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.spellPrevisualization = reader.readBoolean();
		int length = reader.readUShort();
		this.spells = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			SpellItem entry = new SpellItem();
			entry.deserialize(reader);
			this.spells.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.spellPrevisualization);
		writer.writeUShort(this.spells.size());
		for (SpellItem entry : this.spells)
		{
			entry.serialize(writer);
		}
	}
}