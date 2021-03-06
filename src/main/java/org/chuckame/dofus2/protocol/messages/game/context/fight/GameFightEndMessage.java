package org.chuckame.dofus2.protocol.messages.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightResultListEntry;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameFightEndMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 720;
	
	private int duration;
	private short ageBonus;
	private short lootShareLimitMalus;
	private Collection<FightResultListEntry> results;
	
	public GameFightEndMessage() {
	}
	
	public GameFightEndMessage(int duration, short ageBonus, short lootShareLimitMalus, Collection<FightResultListEntry> results) {
		this.duration = duration;
		this.ageBonus = ageBonus;
		this.lootShareLimitMalus = lootShareLimitMalus;
		this.results = results;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.duration = reader.readInt();
		if (duration < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on duration = %s, it doesn't respect the following condition : duration < 0", duration));
		this.ageBonus = reader.readShort();
		this.lootShareLimitMalus = reader.readShort();
		int length = reader.readUShort();
		this.results = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			FightResultListEntry entry = ProtocolTypeManager.getInstance().<FightResultListEntry>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.results.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.duration);
		writer.writeShort(this.ageBonus);
		writer.writeShort(this.lootShareLimitMalus);
		writer.writeUShort(this.results.size());
		for (FightResultListEntry entry : this.results)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
	}
}