package org.chuckame.dofus2.protocol.messages.game.context.mount;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MountSetXpRatioRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5989;
	
	private byte xpRatio;
	
	public MountSetXpRatioRequestMessage() {
	}
	
	public MountSetXpRatioRequestMessage(byte xpRatio) {
		this.xpRatio = xpRatio;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.xpRatio = reader.readSByte();
		if (xpRatio < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on xpRatio = %s, it doesn't respect the following condition : xpRatio < 0", xpRatio));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.xpRatio);
	}
}