package org.michocko.dofus2.protocol.messages.handshake;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.requiredVersion = reader.readInt();
		if (requiredVersion < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on requiredVersion = %s, it doesn't respect the following condition : requiredVersion < 0", requiredVersion));
		this.currentVersion = reader.readInt();
		if (currentVersion < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on currentVersion = %s, it doesn't respect the following condition : currentVersion < 0", currentVersion));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.requiredVersion);
		writer.writeInt(this.currentVersion);
	}
}