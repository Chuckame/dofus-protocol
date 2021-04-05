package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.mount.MountClientData;
import org.michocko.dofus2.protocol.messages.game.inventory.exchanges.ExchangeStartOkMountWithOutPaddockMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeStartOkMountMessage extends ExchangeStartOkMountWithOutPaddockMessage {
	public static final int MESSAGE_ID = 5979;
	
	private Collection<MountClientData> paddockedMountsDescription;
	
	public ExchangeStartOkMountMessage() {
	}
	
	public ExchangeStartOkMountMessage(Collection<MountClientData> stabledMountsDescription, Collection<MountClientData> paddockedMountsDescription) {
		super(stabledMountsDescription);
		this.paddockedMountsDescription = paddockedMountsDescription;
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
		super.deserialize(reader);
		int length = reader.readUShort();
		this.paddockedMountsDescription = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			MountClientData entry = new MountClientData();
			entry.deserialize(reader);
			this.paddockedMountsDescription.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.paddockedMountsDescription.size());
		for (MountClientData entry : this.paddockedMountsDescription)
		{
			entry.serialize(writer);
		}
	}
}