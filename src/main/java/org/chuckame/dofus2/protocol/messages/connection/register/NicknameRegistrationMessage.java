package org.chuckame.dofus2.protocol.messages.connection.register;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class NicknameRegistrationMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5640;
	
	
	public NicknameRegistrationMessage() {
	}
	
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
	}
	
	public void serialize(IDataWriter writer) {
	}
}