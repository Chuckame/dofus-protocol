package org.chuckame.dofus2.protocol.messages.game.basic;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.social.AbstractSocialGroupInfos;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class BasicWhoIsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 180;
	
	private byte position;
	private String accountNickname;
	private int accountId;
	private String playerName;
	private int playerId;
	private short areaId;
	private Collection<AbstractSocialGroupInfos> socialGroups;
	private byte playerState;
	
	public BasicWhoIsMessage() {
	}
	
	public BasicWhoIsMessage(byte position, String accountNickname, int accountId, String playerName, int playerId, short areaId, Collection<AbstractSocialGroupInfos> socialGroups, byte playerState) {
		this.position = position;
		this.accountNickname = accountNickname;
		this.accountId = accountId;
		this.playerName = playerName;
		this.playerId = playerId;
		this.areaId = areaId;
		this.socialGroups = socialGroups;
		this.playerState = playerState;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.position = reader.readSByte();
		this.accountNickname = reader.readUTF();
		this.accountId = reader.readInt();
		if (accountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountId = %s, it doesn't respect the following condition : accountId < 0", accountId));
		this.playerName = reader.readUTF();
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		this.areaId = reader.readShort();
		int length = reader.readUShort();
		this.socialGroups = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			AbstractSocialGroupInfos entry = ProtocolTypeManager.getInstance().<AbstractSocialGroupInfos>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.socialGroups.add(entry);
		}
		this.playerState = reader.readSByte();
		if (playerState < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerState = %s, it doesn't respect the following condition : playerState < 0", playerState));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.position);
		writer.writeUTF(this.accountNickname);
		writer.writeInt(this.accountId);
		writer.writeUTF(this.playerName);
		writer.writeInt(this.playerId);
		writer.writeShort(this.areaId);
		writer.writeUShort(this.socialGroups.size());
		for (AbstractSocialGroupInfos entry : this.socialGroups)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
		writer.writeSByte(this.playerState);
	}
}