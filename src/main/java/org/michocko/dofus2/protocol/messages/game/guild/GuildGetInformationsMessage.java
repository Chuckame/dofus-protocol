package org.michocko.dofus2.protocol.messages.game.guild;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.infoType = reader.readSByte();
		if (infoType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on infoType = %s, it doesn't respect the following condition : infoType < 0", infoType));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.infoType);
	}
}