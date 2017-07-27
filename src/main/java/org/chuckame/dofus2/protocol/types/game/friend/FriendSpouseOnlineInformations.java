package org.chuckame.dofus2.protocol.types.game.friend;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;
import org.chuckame.dofus2.protocol.types.game.friend.FriendSpouseInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FriendSpouseOnlineInformations extends FriendSpouseInformations {
	public static final short TYPE_ID = 93;
	
	private int mapId;
	private short subAreaId;
	
	public FriendSpouseOnlineInformations() {
	}
	
	public FriendSpouseOnlineInformations(int spouseAccountId, int spouseId, String spouseName, short spouseLevel, byte breed, byte sex, EntityLook spouseEntityLook, BasicGuildInformations guildInfo, byte alignmentSide, int mapId, short subAreaId) {
		super(spouseAccountId, spouseId, spouseName, spouseLevel, breed, sex, spouseEntityLook, guildInfo, alignmentSide);
		this.mapId = mapId;
		this.subAreaId = subAreaId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.mapId = reader.readInt();
		if (mapId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on mapId = %s, it doesn't respect the following condition : mapId < 0", mapId));
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.mapId);
		writer.writeShort(this.subAreaId);
	}
}