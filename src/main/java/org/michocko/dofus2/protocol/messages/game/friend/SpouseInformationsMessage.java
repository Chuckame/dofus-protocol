package org.michocko.dofus2.protocol.messages.game.friend;

import org.michocko.dofus2.protocol.types.game.friend.FriendSpouseInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SpouseInformationsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6356;
	
	private FriendSpouseInformations spouse;
	
	public SpouseInformationsMessage() {
	}
	
	public SpouseInformationsMessage(FriendSpouseInformations spouse) {
		this.spouse = spouse;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.spouse = ProtocolTypeManager.getInstance().<FriendSpouseInformations>newInstance(reader.readShort());
		this.spouse.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.spouse.getNetworkTypeId());
		this.spouse.serialize(writer);
	}
}