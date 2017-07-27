package org.chuckame.dofus2.protocol.messages.updater.parts;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.downloadSpeed = reader.readSByte();
		if (downloadSpeed < 1 || downloadSpeed > 10)
			throw new IllegalArgumentException(String.format("Forbidden value on downloadSpeed = %s, it doesn't respect the following condition : downloadSpeed < 1 || downloadSpeed > 10", downloadSpeed));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.downloadSpeed);
	}
}