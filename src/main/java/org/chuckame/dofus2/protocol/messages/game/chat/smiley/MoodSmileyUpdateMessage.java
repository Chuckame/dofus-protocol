package org.chuckame.dofus2.protocol.messages.game.chat.smiley;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MoodSmileyUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6388;
	
	private int accountId;
	private int playerId;
	private byte smileyId;
	
	public MoodSmileyUpdateMessage() {
	}
	
	public MoodSmileyUpdateMessage(int accountId, int playerId, byte smileyId) {
		this.accountId = accountId;
		this.playerId = playerId;
		this.smileyId = smileyId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.accountId = reader.readInt();
		if (accountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountId = %s, it doesn't respect the following condition : accountId < 0", accountId));
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		this.smileyId = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.accountId);
		writer.writeInt(this.playerId);
		writer.writeSByte(this.smileyId);
	}
}