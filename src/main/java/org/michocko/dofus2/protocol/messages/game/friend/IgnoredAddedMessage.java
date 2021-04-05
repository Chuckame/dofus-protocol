package org.michocko.dofus2.protocol.messages.game.friend;

import org.michocko.dofus2.protocol.types.game.friend.IgnoredInformations;

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
public class IgnoredAddedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5678;
	
	private IgnoredInformations ignoreAdded;
	private boolean session;
	
	public IgnoredAddedMessage() {
	}
	
	public IgnoredAddedMessage(IgnoredInformations ignoreAdded, boolean session) {
		this.ignoreAdded = ignoreAdded;
		this.session = session;
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
		this.ignoreAdded = (IgnoredInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
		this.ignoreAdded.deserialize(reader);
		this.session = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.ignoreAdded.getNetworkTypeId());
		this.ignoreAdded.serialize(writer);
		writer.writeBoolean(this.session);
	}
}