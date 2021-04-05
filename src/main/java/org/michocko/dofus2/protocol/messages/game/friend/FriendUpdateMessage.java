package org.michocko.dofus2.protocol.messages.game.friend;

import org.michocko.dofus2.protocol.types.game.friend.FriendInformations;

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
public class FriendUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5924;
	
	private FriendInformations friendUpdated;
	
	public FriendUpdateMessage() {
	}
	
	public FriendUpdateMessage(FriendInformations friendUpdated) {
		this.friendUpdated = friendUpdated;
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
		this.friendUpdated = (FriendInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
		this.friendUpdated.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.friendUpdated.getNetworkTypeId());
		this.friendUpdated.serialize(writer);
	}
}