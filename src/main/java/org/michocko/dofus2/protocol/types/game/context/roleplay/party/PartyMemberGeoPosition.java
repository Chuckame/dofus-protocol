package org.michocko.dofus2.protocol.types.game.context.roleplay.party;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class PartyMemberGeoPosition implements INetworkType {
	public static final short TYPE_ID = 378;
	
	private int memberId;
	private short worldX;
	private short worldY;
	private int mapId;
	private short subAreaId;
	
	public PartyMemberGeoPosition() {
	}
	
	public PartyMemberGeoPosition(int memberId, short worldX, short worldY, int mapId, short subAreaId) {
		this.memberId = memberId;
		this.worldX = worldX;
		this.worldY = worldY;
		this.mapId = mapId;
		this.subAreaId = subAreaId;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.memberId = reader.readInt();
		if (memberId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on memberId = %s, it doesn't respect the following condition : memberId < 0", memberId));
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
		writer.writeInt(this.memberId);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeInt(this.mapId);
		writer.writeShort(this.subAreaId);
	}
}