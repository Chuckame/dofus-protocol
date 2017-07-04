package org.michocko.dofus2.protocol.types.game.guild.tax;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class TaxCollectorBasicInformations implements INetworkType {
	public static final short TYPE_ID = 96;
	
	private short firstNameId;
	private short lastNameId;
	private short worldX;
	private short worldY;
	private int mapId;
	private short subAreaId;
	
	public TaxCollectorBasicInformations() {
	}
	
	public TaxCollectorBasicInformations(short firstNameId, short lastNameId, short worldX, short worldY, int mapId, short subAreaId) {
		this.firstNameId = firstNameId;
		this.lastNameId = lastNameId;
		this.worldX = worldX;
		this.worldY = worldY;
		this.mapId = mapId;
		this.subAreaId = subAreaId;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.firstNameId = reader.readShort();
		if (firstNameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on firstNameId = %s, it doesn't respect the following condition : firstNameId < 0", firstNameId));
		this.lastNameId = reader.readShort();
		if (lastNameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lastNameId = %s, it doesn't respect the following condition : lastNameId < 0", lastNameId));
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
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.firstNameId);
		writer.writeShort(this.lastNameId);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeInt(this.mapId);
		writer.writeShort(this.subAreaId);
	}
}