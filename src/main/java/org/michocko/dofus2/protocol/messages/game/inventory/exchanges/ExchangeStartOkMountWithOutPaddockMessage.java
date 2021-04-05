package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

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
public class ExchangeStartOkMountWithOutPaddockMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5991;
	
	private Collection<MountClientData> stabledMountsDescription;
	
	public ExchangeStartOkMountWithOutPaddockMessage() {
	}
	
	public ExchangeStartOkMountWithOutPaddockMessage(Collection<MountClientData> stabledMountsDescription) {
		this.stabledMountsDescription = stabledMountsDescription;
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
		int length = reader.readUShort();
		this.stabledMountsDescription = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			MountClientData entry = new MountClientData();
			entry.deserialize(reader);
			this.stabledMountsDescription.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.stabledMountsDescription.size());
		for (MountClientData entry : this.stabledMountsDescription)
		{
			entry.serialize(writer);
		}
	}
}