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
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.ignoreAdded = ProtocolTypeManager.getInstance().<IgnoredInformations>newInstance(reader.readShort());
		this.ignoreAdded.deserialize(reader);
		this.session = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.ignoreAdded.getNetworkTypeId());
		this.ignoreAdded.serialize(writer);
		writer.writeBoolean(this.session);
	}
}