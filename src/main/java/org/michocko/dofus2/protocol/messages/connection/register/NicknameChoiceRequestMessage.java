package org.michocko.dofus2.protocol.messages.connection.register;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class NicknameChoiceRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5639;
	
	private String nickname;
	
	public NicknameChoiceRequestMessage() {
	}
	
	public NicknameChoiceRequestMessage(String nickname) {
		this.nickname = nickname;
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
		this.nickname = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.nickname);
	}
}