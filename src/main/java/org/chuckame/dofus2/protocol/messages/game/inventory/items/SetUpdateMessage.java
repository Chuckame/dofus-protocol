package org.chuckame.dofus2.protocol.messages.game.inventory.items;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.data.items.effects.ObjectEffect;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SetUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5503;
	
	private short setId;
	private Collection<Short> setObjects;
	private Collection<ObjectEffect> setEffects;
	
	public SetUpdateMessage() {
	}
	
	public SetUpdateMessage(short setId, Collection<Short> setObjects, Collection<ObjectEffect> setEffects) {
		this.setId = setId;
		this.setObjects = setObjects;
		this.setEffects = setEffects;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.setId = reader.readShort();
		if (setId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on setId = %s, it doesn't respect the following condition : setId < 0", setId));
		int length = reader.readUShort();
		this.setObjects = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.setObjects.add(entry);
		}
		length = reader.readUShort();
		this.setEffects = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectEffect entry = ProtocolTypeManager.getInstance().<ObjectEffect>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.setEffects.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.setId);
		writer.writeUShort(this.setObjects.size());
		for (short entry : this.setObjects)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.setEffects.size());
		for (ObjectEffect entry : this.setEffects)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
	}
}