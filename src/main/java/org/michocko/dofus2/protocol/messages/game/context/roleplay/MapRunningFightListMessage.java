package org.michocko.dofus2.protocol.messages.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.fight.FightExternalInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.fights = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			FightExternalInformations entry = new FightExternalInformations();
			entry.deserialize(reader);
			this.fights.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.fights.size());
		for (FightExternalInformations entry : this.fights)
		{
			entry.serialize(writer);
		}
	}
}