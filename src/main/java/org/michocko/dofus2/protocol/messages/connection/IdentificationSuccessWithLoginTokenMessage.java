package org.michocko.dofus2.protocol.messages.connection;

import org.michocko.dofus2.protocol.messages.connection.IdentificationSuccessMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class IdentificationSuccessWithLoginTokenMessage extends IdentificationSuccessMessage {
	public static final int MESSAGE_ID = 6209;
	
	private String loginToken;
	
	public IdentificationSuccessWithLoginTokenMessage() {
	}
	
	public IdentificationSuccessWithLoginTokenMessage(String login, String nickname, int accountId, byte communityId, String secretQuestion, double subscriptionEndDate, double accountCreation, String loginToken) {
		super(login, nickname, accountId, communityId, secretQuestion, subscriptionEndDate, accountCreation);
		this.loginToken = loginToken;
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
		super.deserialize(reader);
		this.loginToken = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.loginToken);
	}
}