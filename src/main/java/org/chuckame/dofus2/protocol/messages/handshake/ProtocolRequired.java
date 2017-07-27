package org.chuckame.dofus2.protocol.messages.handshake;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ProtocolRequired implements INetworkMessage {
	public static final int MESSAGE_ID = 1;
	
	private int requiredVersion;
	private int currentVersion;
	
	public ProtocolRequired() {
	}
	
	public ProtocolRequired(int requiredVersion, int currentVersion) {
		this.requiredVersion = requiredVersion;
		this.currentVersion = currentVersion;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.requiredVersion = reader.readInt();
		if (requiredVersion < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on requiredVersion = %s, it doesn't respect the following condition : requiredVersion < 0", requiredVersion));
		this.currentVersion = reader.readInt();
		if (currentVersion < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on currentVersion = %s, it doesn't respect the following condition : currentVersion < 0", currentVersion));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.requiredVersion);
		writer.writeInt(this.currentVersion);
	}
}