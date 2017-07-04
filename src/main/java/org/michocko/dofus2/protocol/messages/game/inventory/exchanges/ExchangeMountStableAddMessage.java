package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.types.game.mount.MountClientData;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeMountStableAddMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5971;
	
	private MountClientData mountDescription;
	
	public ExchangeMountStableAddMessage() {
	}
	
	public ExchangeMountStableAddMessage(MountClientData mountDescription) {
		this.mountDescription = mountDescription;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mountDescription = new MountClientData();
		this.mountDescription.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.mountDescription.serialize(writer);
	}
}