package org.chuckame.dofus2.protocol.types.game.friend;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.friend.AbstractContactInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FriendInformations extends AbstractContactInformations {
	public static final short TYPE_ID = 78;
	
	private byte playerState;
	private int lastConnection;
	private int achievementPoints;
	
	public FriendInformations() {
	}
	
	public FriendInformations(int accountId, String accountName, byte playerState, int lastConnection, int achievementPoints) {
		super(accountId, accountName);
		this.playerState = playerState;
		this.lastConnection = lastConnection;
		this.achievementPoints = achievementPoints;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.playerState = reader.readSByte();
		if (playerState < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerState = %s, it doesn't respect the following condition : playerState < 0", playerState));
		this.lastConnection = reader.readInt();
		if (lastConnection < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lastConnection = %s, it doesn't respect the following condition : lastConnection < 0", lastConnection));
		this.achievementPoints = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.playerState);
		writer.writeInt(this.lastConnection);
		writer.writeInt(this.achievementPoints);
	}
}