package org.michocko.dofus2.protocol.messages.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.fight.GameFightFighterInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameFightSynchronizeMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5921;
	
	private Collection<GameFightFighterInformations> fighters;
	
	public GameFightSynchronizeMessage() {
	}
	
	public GameFightSynchronizeMessage(Collection<GameFightFighterInformations> fighters) {
		this.fighters = fighters;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.fighters = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GameFightFighterInformations entry = ProtocolTypeManager.getInstance().<GameFightFighterInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.fighters.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.fighters.size());
		for (GameFightFighterInformations entry : this.fighters)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}