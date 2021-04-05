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
public class ExchangeMountPaddockAddMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6049;
	
	private MountClientData mountDescription;
	
	public ExchangeMountPaddockAddMessage() {
	}
	
	public ExchangeMountPaddockAddMessage(MountClientData mountDescription) {
		this.mountDescription = mountDescription;
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
		this.mountDescription = new MountClientData();
		this.mountDescription.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.mountDescription.serialize(writer);
	}
}