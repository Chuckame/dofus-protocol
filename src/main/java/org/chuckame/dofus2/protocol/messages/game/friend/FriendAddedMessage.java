package org.chuckame.dofus2.protocol.messages.game.friend;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.friend.FriendInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class FriendAddedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5599;
	
	private FriendInformations friendAdded;
	
	public FriendAddedMessage() {
	}
	
	public FriendAddedMessage(FriendInformations friendAdded) {
		this.friendAdded = friendAdded;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.friendAdded = ProtocolTypeManager.getInstance().<FriendInformations>newInstance(reader.readShort());
		this.friendAdded.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.friendAdded.getProtocolTypeId());
		this.friendAdded.serialize(writer);
	}
}