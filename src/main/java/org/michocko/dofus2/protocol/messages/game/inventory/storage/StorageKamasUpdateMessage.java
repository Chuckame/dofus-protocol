package org.michocko.dofus2.protocol.messages.game.inventory.storage;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class StorageKamasUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5645;
	
	private int kamasTotal;
	
	public StorageKamasUpdateMessage() {
	}
	
	public StorageKamasUpdateMessage(int kamasTotal) {
		this.kamasTotal = kamasTotal;
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
		this.kamasTotal = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.kamasTotal);
	}
}