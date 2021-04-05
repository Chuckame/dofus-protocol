package org.michocko.dofus2.protocol.messages.game.social;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ContactLookRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5932;
	
	private short requestId;
	private byte contactType;
	
	public ContactLookRequestMessage() {
	}
	
	public ContactLookRequestMessage(short requestId, byte contactType) {
		this.requestId = requestId;
		this.contactType = contactType;
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
		this.requestId = reader.readByte();
		if (requestId < 0 || requestId > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on requestId = %s, it doesn't respect the following condition : requestId < 0 || requestId > 255", requestId));
		this.contactType = reader.readSByte();
		if (contactType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on contactType = %s, it doesn't respect the following condition : contactType < 0", contactType));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeByte(this.requestId);
		writer.writeSByte(this.contactType);
	}
}