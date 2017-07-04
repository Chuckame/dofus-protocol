package org.michocko.dofus2.protocol.messages.game.approach;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ServerSettingsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6340;
	
	private String lang;
	private byte community;
	private byte gameType;
	
	public ServerSettingsMessage() {
	}
	
	public ServerSettingsMessage(String lang, byte community, byte gameType) {
		this.lang = lang;
		this.community = community;
		this.gameType = gameType;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.lang = reader.readUTF();
		this.community = reader.readSByte();
		if (community < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on community = %s, it doesn't respect the following condition : community < 0", community));
		this.gameType = reader.readSByte();
		if (gameType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on gameType = %s, it doesn't respect the following condition : gameType < 0", gameType));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.lang);
		writer.writeSByte(this.community);
		writer.writeSByte(this.gameType);
	}
}