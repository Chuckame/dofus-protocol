package org.michocko.dofus2.protocol.types.game.paddock;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.paddock.MountInformationsForPaddock;
import org.michocko.dofus2.protocol.types.game.paddock.PaddockInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class PaddockContentInformations extends PaddockInformations {
	public static final short TYPE_ID = 183;
	
	private int paddockId;
	private short worldX;
	private short worldY;
	private int mapId;
	private short subAreaId;
	private boolean abandonned;
	private Collection<MountInformationsForPaddock> mountsInformations;
	
	public PaddockContentInformations() {
	}
	
	public PaddockContentInformations(short maxOutdoorMount, short maxItems, int paddockId, short worldX, short worldY, int mapId, short subAreaId, boolean abandonned, Collection<MountInformationsForPaddock> mountsInformations) {
		super(maxOutdoorMount, maxItems);
		this.paddockId = paddockId;
		this.worldX = worldX;
		this.worldY = worldY;
		this.mapId = mapId;
		this.subAreaId = subAreaId;
		this.abandonned = abandonned;
		this.mountsInformations = mountsInformations;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.paddockId = reader.readInt();
		this.worldX = reader.readShort();
		if (worldX < -255 || worldX > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldX = %s, it doesn't respect the following condition : worldX < -255 || worldX > 255", worldX));
		this.worldY = reader.readShort();
		if (worldY < -255 || worldY > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldY = %s, it doesn't respect the following condition : worldY < -255 || worldY > 255", worldY));
		this.mapId = reader.readInt();
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.abandonned = reader.readBoolean();
		int length = reader.readUShort();
		this.mountsInformations = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			MountInformationsForPaddock entry = new MountInformationsForPaddock();
			entry.deserialize(reader);
			this.mountsInformations.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.paddockId);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeInt(this.mapId);
		writer.writeShort(this.subAreaId);
		writer.writeBoolean(this.abandonned);
		writer.writeUShort(this.mountsInformations.size());
		for (MountInformationsForPaddock entry : this.mountsInformations)
		{
			entry.serialize(writer);
		}
	}
}