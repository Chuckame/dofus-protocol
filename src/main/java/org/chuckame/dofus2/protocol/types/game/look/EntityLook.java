package org.chuckame.dofus2.protocol.types.game.look;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.protocol.types.game.look.SubEntity;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class EntityLook implements INetworkType {
	public static final short TYPE_ID = 55;
	
	private short bonesId;
	private Collection<Short> skins;
	private Collection<Integer> indexedColors;
	private Collection<Short> scales;
	private Collection<SubEntity> subentities;
	
	public EntityLook() {
	}
	
	public EntityLook(short bonesId, Collection<Short> skins, Collection<Integer> indexedColors, Collection<Short> scales, Collection<SubEntity> subentities) {
		this.bonesId = bonesId;
		this.skins = skins;
		this.indexedColors = indexedColors;
		this.scales = scales;
		this.subentities = subentities;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.bonesId = reader.readShort();
		if (bonesId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on bonesId = %s, it doesn't respect the following condition : bonesId < 0", bonesId));
		int length = reader.readUShort();
		this.skins = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.skins.add(entry);
		}
		length = reader.readUShort();
		this.indexedColors = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.indexedColors.add(entry);
		}
		length = reader.readUShort();
		this.scales = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.scales.add(entry);
		}
		length = reader.readUShort();
		this.subentities = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			SubEntity entry = new SubEntity();
			entry.deserialize(reader);
			this.subentities.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.bonesId);
		writer.writeUShort(this.skins.size());
		for (short entry : this.skins)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.indexedColors.size());
		for (int entry : this.indexedColors)
		{
			writer.writeInt(entry);
		}
		writer.writeUShort(this.scales.size());
		for (short entry : this.scales)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.subentities.size());
		for (SubEntity entry : this.subentities)
		{
			entry.serialize(writer);
		}
	}
}