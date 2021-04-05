package org.michocko.dofus2.protocol.types.game.friend;

import org.michocko.dofus2.protocol.enums.PlayableBreedEnum;
import org.michocko.dofus2.protocol.types.game.friend.IgnoredInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class IgnoredOnlineInformations extends IgnoredInformations {
	public static final short TYPE_ID = 105;
	
	private int playerId;
	private String playerName;
	private PlayableBreedEnum breed;
	private boolean sex;
	
	public IgnoredOnlineInformations() {
	}
	
	public IgnoredOnlineInformations(int accountId, String accountName, int playerId, String playerName, PlayableBreedEnum breed, boolean sex) {
		super(accountId, accountName);
		this.playerId = playerId;
		this.playerName = playerName;
		this.breed = breed;
		this.sex = sex;
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
		this.breed = PlayableBreedEnum.valueOf(reader.readSByte());
		if (this.breed != null)
			throw new IllegalArgumentException(String.format("Forbidden value on breed = %s, it doesn't respect the following condition : this.breed != null", breed));
		this.sex = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.playerId);
		writer.writeUTF(this.playerName);
		writer.writeSByte((byte)this.breed.getValue());
		writer.writeBoolean(this.sex);
	}
}