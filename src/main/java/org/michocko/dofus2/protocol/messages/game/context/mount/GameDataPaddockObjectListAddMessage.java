package org.michocko.dofus2.protocol.messages.game.context.mount;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.paddock.PaddockItem;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameDataPaddockObjectListAddMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5992;
	
	private Collection<PaddockItem> paddockItemDescription;
	
	public GameDataPaddockObjectListAddMessage() {
	}
	
	public GameDataPaddockObjectListAddMessage(Collection<PaddockItem> paddockItemDescription) {
		this.paddockItemDescription = paddockItemDescription;
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
		this.paddockItemDescription = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PaddockItem entry = new PaddockItem();
			entry.deserialize(reader);
			this.paddockItemDescription.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.paddockItemDescription.size());
		for (PaddockItem entry : this.paddockItemDescription)
		{
			entry.serialize(writer);
		}
	}
}