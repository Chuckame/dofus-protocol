package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.mount.MountClientData;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeMountPaddockAddMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6049;
	
	private MountClientData mountDescription;
	
	public ExchangeMountPaddockAddMessage() {
	}
	
	public ExchangeMountPaddockAddMessage(MountClientData mountDescription) {
		this.mountDescription = mountDescription;
	}
	
	public int getProtocolId() {
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