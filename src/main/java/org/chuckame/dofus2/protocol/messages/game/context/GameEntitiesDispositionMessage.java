package org.chuckame.dofus2.protocol.messages.game.context;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.IdentifiedEntityDispositionInformations;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
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
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.dispositions.size());
		for (IdentifiedEntityDispositionInformations entry : this.dispositions)
		{
			entry.serialize(writer);
		}
	}
}