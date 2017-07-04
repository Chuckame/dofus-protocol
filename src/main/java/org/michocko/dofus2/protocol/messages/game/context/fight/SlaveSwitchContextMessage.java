package org.michocko.dofus2.protocol.messages.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.SpellItem;
import org.michocko.dofus2.protocol.types.game.character.characteristic.CharacterCharacteristicsInformations;
import org.michocko.dofus2.protocol.types.game.shortcut.Shortcut;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SlaveSwitchContextMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6214;
	
	private int masterId;
	private int slaveId;
	private Collection<SpellItem> slaveSpells;
	private CharacterCharacteristicsInformations slaveStats;
	private Collection<Shortcut> shortcuts;
	
	public SlaveSwitchContextMessage() {
	}
	
	public SlaveSwitchContextMessage(int masterId, int slaveId, Collection<SpellItem> slaveSpells, CharacterCharacteristicsInformations slaveStats, Collection<Shortcut> shortcuts) {
		this.masterId = masterId;
		this.slaveId = slaveId;
		this.slaveSpells = slaveSpells;
		this.slaveStats = slaveStats;
		this.shortcuts = shortcuts;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.masterId = reader.readInt();
		this.slaveId = reader.readInt();
		int length = reader.readUShort();
		this.slaveSpells = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			SpellItem entry = new SpellItem();
			entry.deserialize(reader);
			this.slaveSpells.add(entry);
		}
		this.slaveStats = new CharacterCharacteristicsInformations();
		this.slaveStats.deserialize(reader);
		length = reader.readUShort();
		this.shortcuts = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			Shortcut entry = ProtocolTypeManager.getInstance().<Shortcut>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.shortcuts.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.masterId);
		writer.writeInt(this.slaveId);
		writer.writeUShort(this.slaveSpells.size());
		for (SpellItem entry : this.slaveSpells)
		{
			entry.serialize(writer);
		}
		this.slaveStats.serialize(writer);
		writer.writeUShort(this.shortcuts.size());
		for (Shortcut entry : this.shortcuts)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}