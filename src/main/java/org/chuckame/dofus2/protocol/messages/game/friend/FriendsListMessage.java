package org.chuckame.dofus2.protocol.messages.game.friend;

import java.util.Collection;
import java.util.LinkedList;

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
public class FriendsListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 4002;
	
	private Collection<FriendInformations> friendsList;
	
	public FriendsListMessage() {
	}
	
	public FriendsListMessage(Collection<FriendInformations> friendsList) {
		this.friendsList = friendsList;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.friendsList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			FriendInformations entry = ProtocolTypeManager.getInstance().<FriendInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.friendsList.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.friendsList.size());
		for (FriendInformations entry : this.friendsList)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
	}
}