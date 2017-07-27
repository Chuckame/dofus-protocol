package org.chuckame.dofus2.protocol.messages.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightFighterLightInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MapRunningFightDetailsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5751;
	
	private int fightId;
	private Collection<GameFightFighterLightInformations> attackers;
	private Collection<GameFightFighterLightInformations> defenders;
	
	public MapRunningFightDetailsMessage() {
	}
	
	public MapRunningFightDetailsMessage(int fightId, Collection<GameFightFighterLightInformations> attackers, Collection<GameFightFighterLightInformations> defenders) {
		this.fightId = fightId;
		this.attackers = attackers;
		this.defenders = defenders;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightId = reader.readInt();
		if (fightId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightId = %s, it doesn't respect the following condition : fightId < 0", fightId));
		int length = reader.readUShort();
		this.attackers = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GameFightFighterLightInformations entry = ProtocolTypeManager.getInstance().<GameFightFighterLightInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.attackers.add(entry);
		}
		length = reader.readUShort();
		this.defenders = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GameFightFighterLightInformations entry = ProtocolTypeManager.getInstance().<GameFightFighterLightInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.defenders.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.fightId);
		writer.writeUShort(this.attackers.size());
		for (GameFightFighterLightInformations entry : this.attackers)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
		writer.writeUShort(this.defenders.size());
		for (GameFightFighterLightInformations entry : this.defenders)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
	}
}