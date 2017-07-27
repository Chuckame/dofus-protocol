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
public class FriendUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5924;
	
	private FriendInformations friendUpdated;
	
	public FriendUpdateMessage() {
	}
	
	public FriendUpdateMessage(FriendInformations friendUpdated) {
		this.friendUpdated = friendUpdated;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.friendUpdated = ProtocolTypeManager.getInstance().<FriendInformations>newInstance(reader.readShort());
		this.friendUpdated.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.friendUpdated.getProtocolTypeId());
		this.friendUpdated.serialize(writer);
	}
}