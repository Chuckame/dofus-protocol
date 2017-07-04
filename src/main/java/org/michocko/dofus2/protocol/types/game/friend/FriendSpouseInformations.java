package org.michocko.dofus2.protocol.types.game.friend;

import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class FriendSpouseInformations implements INetworkType {
	public static final short TYPE_ID = 77;
	
	private int spouseAccountId;
	private int spouseId;
	private String spouseName;
	private short spouseLevel;
	private byte breed;
	private byte sex;
	private EntityLook spouseEntityLook;
	private BasicGuildInformations guildInfo;
	private byte alignmentSide;
	
	public FriendSpouseInformations() {
	}
	
	public FriendSpouseInformations(int spouseAccountId, int spouseId, String spouseName, short spouseLevel, byte breed, byte sex, EntityLook spouseEntityLook, BasicGuildInformations guildInfo, byte alignmentSide) {
		this.spouseAccountId = spouseAccountId;
		this.spouseId = spouseId;
		this.spouseName = spouseName;
		this.spouseLevel = spouseLevel;
		this.breed = breed;
		this.sex = sex;
		this.spouseEntityLook = spouseEntityLook;
		this.guildInfo = guildInfo;
		this.alignmentSide = alignmentSide;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.spouseAccountId = reader.readInt();
		if (spouseAccountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spouseAccountId = %s, it doesn't respect the following condition : spouseAccountId < 0", spouseAccountId));
		this.spouseId = reader.readInt();
		if (spouseId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spouseId = %s, it doesn't respect the following condition : spouseId < 0", spouseId));
		this.spouseName = reader.readUTF();
		this.spouseLevel = reader.readByte();
		if (spouseLevel < 1 || spouseLevel > 200)
			throw new IllegalArgumentException(String.format("Forbidden value on spouseLevel = %s, it doesn't respect the following condition : spouseLevel < 1 || spouseLevel > 200", spouseLevel));
		this.breed = reader.readSByte();
		this.sex = reader.readSByte();
		this.spouseEntityLook = new EntityLook();
		this.spouseEntityLook.deserialize(reader);
		this.guildInfo = new BasicGuildInformations();
		this.guildInfo.deserialize(reader);
		this.alignmentSide = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.spouseAccountId);
		writer.writeInt(this.spouseId);
		writer.writeUTF(this.spouseName);
		writer.writeByte(this.spouseLevel);
		writer.writeSByte(this.breed);
		writer.writeSByte(this.sex);
		this.spouseEntityLook.serialize(writer);
		this.guildInfo.serialize(writer);
		writer.writeSByte(this.alignmentSide);
	}
}