package org.chuckame.dofus2.protocol.messages.game.context.roleplay.fight.arena;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameRolePlayArenaFightPropositionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6276;
	
	private int fightId;
	private Collection<Integer> alliesId;
	private short duration;
	
	public GameRolePlayArenaFightPropositionMessage() {
	}
	
	public GameRolePlayArenaFightPropositionMessage(int fightId, Collection<Integer> alliesId, short duration) {
		this.fightId = fightId;
		this.alliesId = alliesId;
		this.duration = duration;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightId = reader.readInt();
		if (fightId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightId = %s, it doesn't respect the following condition : fightId < 0", fightId));
		int length = reader.readUShort();
		this.alliesId = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.alliesId.add(entry);
		}
		this.duration = reader.readShort();
		if (duration < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on duration = %s, it doesn't respect the following condition : duration < 0", duration));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.fightId);
		writer.writeUShort(this.alliesId.size());
		for (int entry : this.alliesId)
		{
			writer.writeInt(entry);
		}
		writer.writeShort(this.duration);
	}
}