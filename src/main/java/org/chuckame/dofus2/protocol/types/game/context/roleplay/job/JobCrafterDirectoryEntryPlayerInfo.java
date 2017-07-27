package org.chuckame.dofus2.protocol.types.game.context.roleplay.job;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.enums.PlayableBreedEnum;
import org.chuckame.dofus2.protocol.types.game.character.status.PlayerStatus;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class JobCrafterDirectoryEntryPlayerInfo implements INetworkType {
	public static final short TYPE_ID = 194;
	
	private int playerId;
	private String playerName;
	private byte alignmentSide;
	private PlayableBreedEnum breed;
	private boolean sex;
	private boolean isInWorkshop;
	private short worldX;
	private short worldY;
	private int mapId;
	private short subAreaId;
	private PlayerStatus status;
	
	public JobCrafterDirectoryEntryPlayerInfo() {
	}
	
	public JobCrafterDirectoryEntryPlayerInfo(int playerId, String playerName, byte alignmentSide, PlayableBreedEnum breed, boolean sex, boolean isInWorkshop, short worldX, short worldY, int mapId, short subAreaId, PlayerStatus status) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.alignmentSide = alignmentSide;
		this.breed = breed;
		this.sex = sex;
		this.isInWorkshop = isInWorkshop;
		this.worldX = worldX;
		this.worldY = worldY;
		this.mapId = mapId;
		this.subAreaId = subAreaId;
		this.status = status;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		this.playerName = reader.readUTF();
		this.alignmentSide = reader.readSByte();
		this.breed = PlayableBreedEnum.valueOf(reader.readSByte());
		if (this.breed != null)
			throw new IllegalArgumentException(String.format("Forbidden value on breed = %s, it doesn't respect the following condition : this.breed != null", breed));
		this.sex = reader.readBoolean();
		this.isInWorkshop = reader.readBoolean();
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
		this.status = ProtocolTypeManager.getInstance().<PlayerStatus>newInstance(reader.readShort());
		this.status.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.playerId);
		writer.writeUTF(this.playerName);
		writer.writeSByte(this.alignmentSide);
		writer.writeSByte((byte)this.breed.getValue());
		writer.writeBoolean(this.sex);
		writer.writeBoolean(this.isInWorkshop);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeInt(this.mapId);
		writer.writeShort(this.subAreaId);
		writer.writeShort(this.status.getProtocolTypeId());
		this.status.serialize(writer);
	}
}