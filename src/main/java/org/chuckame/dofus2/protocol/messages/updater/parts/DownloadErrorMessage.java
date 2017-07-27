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
public class DownloadErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1513;
	
	private byte errorId;
	private String message;
	private String helpUrl;
	
	public DownloadErrorMessage() {
	}
	
	public DownloadErrorMessage(byte errorId, String message, String helpUrl) {
		this.errorId = errorId;
		this.message = message;
		this.helpUrl = helpUrl;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.errorId = reader.readSByte();
		if (errorId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on errorId = %s, it doesn't respect the following condition : errorId < 0", errorId));
		this.message = reader.readUTF();
		this.helpUrl = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.errorId);
		writer.writeUTF(this.message);
		writer.writeUTF(this.helpUrl);
	}
}