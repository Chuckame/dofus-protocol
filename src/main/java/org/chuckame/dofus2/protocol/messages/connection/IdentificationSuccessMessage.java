package org.chuckame.dofus2.protocol.messages.connection;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class IdentificationSuccessMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 22;
	
	private String login;
	private String nickname;
	private int accountId;
	private byte communityId;
	private String secretQuestion;
	private double subscriptionEndDate;
	private double accountCreation;
	
	public IdentificationSuccessMessage() {
	}
	
	public IdentificationSuccessMessage(String login, String nickname, int accountId, byte communityId, String secretQuestion, double subscriptionEndDate, double accountCreation) {
		this.login = login;
		this.nickname = nickname;
		this.accountId = accountId;
		this.communityId = communityId;
		this.secretQuestion = secretQuestion;
		this.subscriptionEndDate = subscriptionEndDate;
		this.accountCreation = accountCreation;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.login = reader.readUTF();
		this.nickname = reader.readUTF();
		this.accountId = reader.readInt();
		if (accountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountId = %s, it doesn't respect the following condition : accountId < 0", accountId));
		this.communityId = reader.readSByte();
		if (communityId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on communityId = %s, it doesn't respect the following condition : communityId < 0", communityId));
		this.secretQuestion = reader.readUTF();
		this.subscriptionEndDate = reader.readDouble();
		if (subscriptionEndDate < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subscriptionEndDate = %s, it doesn't respect the following condition : subscriptionEndDate < 0", subscriptionEndDate));
		this.accountCreation = reader.readDouble();
		if (accountCreation < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountCreation = %s, it doesn't respect the following condition : accountCreation < 0", accountCreation));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.login);
		writer.writeUTF(this.nickname);
		writer.writeInt(this.accountId);
		writer.writeSByte(this.communityId);
		writer.writeUTF(this.secretQuestion);
		writer.writeDouble(this.subscriptionEndDate);
		writer.writeDouble(this.accountCreation);
	}
}