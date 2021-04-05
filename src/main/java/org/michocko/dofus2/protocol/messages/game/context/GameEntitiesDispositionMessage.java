package org.michocko.dofus2.protocol.messages.game.context;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.IdentifiedEntityDispositionInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameEntitiesDispositionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5696;
	
	private Collection<IdentifiedEntityDispositionInformations> dispositions;
	
	public GameEntitiesDispositionMessage() {
	}
	
	public GameEntitiesDispositionMessage(Collection<IdentifiedEntityDispositionInformations> dispositions) {
		this.dispositions = dispositions;
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
		this.dispositions = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			IdentifiedEntityDispositionInformations entry = new IdentifiedEntityDispositionInformations();
			entry.deserialize(reader);
			this.dispositions.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.dispositions.size());
		for (IdentifiedEntityDispositionInformations entry : this.dispositions)
		{
			entry.serialize(writer);
		}
	}
}