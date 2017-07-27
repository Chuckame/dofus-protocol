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
public class GuildGetInformationsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5550;
	
	private byte infoType;
	
	public GuildGetInformationsMessage() {
	}
	
	public GuildGetInformationsMessage(byte infoType) {
		this.infoType = infoType;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.infoType = reader.readSByte();
		if (infoType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on infoType = %s, it doesn't respect the following condition : infoType < 0", infoType));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.infoType);
	}
}