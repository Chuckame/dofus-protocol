package org.chuckame.dofus2.protocol.messages.game.guild;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildCreationResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5554;
	
	private byte result;
	
	public GuildCreationResultMessage() {
	}
	
	public GuildCreationResultMessage(byte result) {
		this.result = result;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.result = reader.readSByte();
		if (result < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on result = %s, it doesn't respect the following condition : result < 0", result));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.result);
	}
}