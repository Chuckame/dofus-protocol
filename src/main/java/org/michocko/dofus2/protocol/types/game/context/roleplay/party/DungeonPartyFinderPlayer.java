package org.michocko.dofus2.protocol.types.game.context.roleplay.party;

import org.michocko.dofus2.protocol.enums.PlayableBreedEnum;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class DungeonPartyFinderPlayer implements INetworkType {
	public static final short TYPE_ID = 373;
	
	private int playerId;
	private String playerName;
	private PlayableBreedEnum breed;
	private boolean sex;
	private short level;
	
	public DungeonPartyFinderPlayer() {
	}
	
	public DungeonPartyFinderPlayer(int playerId, String playerName, PlayableBreedEnum breed, boolean sex, short level) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.breed = breed;
		this.sex = sex;
		this.level = level;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		this.playerName = reader.readUTF();
		this.breed = PlayableBreedEnum.valueOf(reader.readSByte());
		if (this.breed != null)
			throw new IllegalArgumentException(String.format("Forbidden value on breed = %s, it doesn't respect the following condition : this.breed != null", breed));
		this.sex = reader.readBoolean();
		this.level = reader.readShort();
		if (level < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0", level));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.playerId);
		writer.writeUTF(this.playerName);
		writer.writeSByte((byte)this.breed.getValue());
		writer.writeBoolean(this.sex);
		writer.writeShort(this.level);
	}
}