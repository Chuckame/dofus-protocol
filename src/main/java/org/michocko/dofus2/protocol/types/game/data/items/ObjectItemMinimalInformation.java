package org.michocko.dofus2.protocol.types.game.data.items;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.effects.ObjectEffect;
import org.michocko.dofus2.protocol.types.game.data.items.Item;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ObjectItemMinimalInformation extends Item {
	public static final short TYPE_ID = 124;
	
	private short objectGID;
	private Collection<ObjectEffect> effects;
	
	public ObjectItemMinimalInformation() {
	}
	
	public ObjectItemMinimalInformation(short objectGID, Collection<ObjectEffect> effects) {
		this.objectGID = objectGID;
		this.effects = effects;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.objectGID = reader.readShort();
		if (objectGID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectGID = %s, it doesn't respect the following condition : objectGID < 0", objectGID));
		int length = reader.readUShort();
		this.effects = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectEffect entry = (ObjectEffect) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
			entry.deserialize(reader);
			this.effects.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.objectGID);
		writer.writeUShort(this.effects.size());
		for (ObjectEffect entry : this.effects)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}