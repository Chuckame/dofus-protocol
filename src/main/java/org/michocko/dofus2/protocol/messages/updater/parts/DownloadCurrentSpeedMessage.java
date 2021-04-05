package org.michocko.dofus2.protocol.messages.updater.parts;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class DownloadCurrentSpeedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1511;
	
	private byte downloadSpeed;
	
	public DownloadCurrentSpeedMessage() {
	}
	
	public DownloadCurrentSpeedMessage(byte downloadSpeed) {
		this.downloadSpeed = downloadSpeed;
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
		this.downloadSpeed = reader.readSByte();
		if (downloadSpeed < 1 || downloadSpeed > 10)
			throw new IllegalArgumentException(String.format("Forbidden value on downloadSpeed = %s, it doesn't respect the following condition : downloadSpeed < 1 || downloadSpeed > 10", downloadSpeed));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.downloadSpeed);
	}
}