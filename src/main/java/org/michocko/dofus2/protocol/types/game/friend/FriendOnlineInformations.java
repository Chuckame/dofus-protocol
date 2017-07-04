package org.michocko.dofus2.protocol.types.game.friend;

import org.michocko.dofus2.protocol.enums.PlayableBreedEnum;
import org.michocko.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;
import org.michocko.dofus2.protocol.types.game.character.status.PlayerStatus;
import org.michocko.dofus2.protocol.types.game.friend.FriendInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FriendOnlineInformations extends FriendInformations {
	public static final short TYPE_ID = 92;
	
	private int playerId;
	private String playerName;
	private short level;
	private byte alignmentSide;
	private PlayableBreedEnum breed;
	private boolean sex;
	private BasicGuildInformations guildInfo;
	private byte moodSmileyId;
	private PlayerStatus status;
	
	public FriendOnlineInformations() {
	}
	
	public FriendOnlineInformations(int accountId, String accountName, byte playerState, int lastConnection, int achievementPoints, int playerId, String playerName, short level, byte alignmentSide, PlayableBreedEnum breed, boolean sex, BasicGuildInformations guildInfo, byte moodSmileyId, PlayerStatus status) {
		super(accountId, accountName, playerState, lastConnection, achievementPoints);
		this.playerId = playerId;
		this.playerName = playerName;
		this.level = level;
		this.alignmentSide = alignmentSide;
		this.breed = breed;
		this.sex = sex;
		this.guildInfo = guildInfo;
		this.moodSmileyId = moodSmileyId;
		this.status = status;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		this.playerName = reader.readUTF();
		this.level = reader.readShort();
		if (level < 0 || level > 200)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0 || level > 200", level));
		this.alignmentSide = reader.readSByte();
		this.breed = PlayableBreedEnum.valueOf(reader.readSByte());
		if (this.breed != null)
			throw new IllegalArgumentException(String.format("Forbidden value on breed = %s, it doesn't respect the following condition : this.breed != null", breed));
		this.sex = reader.readBoolean();
		this.guildInfo = new BasicGuildInformations();
		this.guildInfo.deserialize(reader);
		this.moodSmileyId = reader.readSByte();
		this.status = ProtocolTypeManager.getInstance().<PlayerStatus>newInstance(reader.readShort());
		this.status.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.playerId);
		writer.writeUTF(this.playerName);
		writer.writeShort(this.level);
		writer.writeSByte(this.alignmentSide);
		writer.writeSByte((byte)this.breed.getValue());
		writer.writeBoolean(this.sex);
		this.guildInfo.serialize(writer);
		writer.writeSByte(this.moodSmileyId);
		writer.writeShort(this.status.getNetworkTypeId());
		this.status.serialize(writer);
	}
}