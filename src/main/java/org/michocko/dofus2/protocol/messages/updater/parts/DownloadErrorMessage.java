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
		this.errorId = reader.readSByte();
		if (errorId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on errorId = %s, it doesn't respect the following condition : errorId < 0", errorId));
		this.message = reader.readUTF();
		this.helpUrl = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.errorId);
		writer.writeUTF(this.message);
		writer.writeUTF(this.helpUrl);
	}
}