package org.michocko.dofus2.protocol.messages.game.social;

import org.michocko.dofus2.protocol.messages.game.social.ContactLookRequestMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ContactLookRequestByIdMessage extends ContactLookRequestMessage {
	public static final int MESSAGE_ID = 5935;
	
	private int playerId;
	
	public ContactLookRequestByIdMessage() {
	}
	
	public ContactLookRequestByIdMessage(short requestId, byte contactType, int playerId) {
		super(requestId, contactType);
		this.playerId = playerId;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.playerId);
	}
}