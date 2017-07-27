package org.chuckame.dofus2.protocol.messages.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightExternalInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MapRunningFightListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5743;
	
	private Collection<FightExternalInformations> fights;
	
	public MapRunningFightListMessage() {
	}
	
	public MapRunningFightListMessage(Collection<FightExternalInformations> fights) {
		this.fights = fights;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.fights = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			FightExternalInformations entry = new FightExternalInformations();
			entry.deserialize(reader);
			this.fights.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.fights.size());
		for (FightExternalInformations entry : this.fights)
		{
			entry.serialize(writer);
		}
	}
}