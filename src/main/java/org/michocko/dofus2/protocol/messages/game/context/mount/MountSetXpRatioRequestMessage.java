package org.michocko.dofus2.protocol.messages.game.context.mount;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.xpRatio = reader.readSByte();
		if (xpRatio < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on xpRatio = %s, it doesn't respect the following condition : xpRatio < 0", xpRatio));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.xpRatio);
	}
}