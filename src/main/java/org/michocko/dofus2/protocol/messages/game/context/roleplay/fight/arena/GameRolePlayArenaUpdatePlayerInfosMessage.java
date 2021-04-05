package org.michocko.dofus2.protocol.messages.game.context.roleplay.fight.arena;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameRolePlayArenaUpdatePlayerInfosMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6301;
	
	private short rank;
	private short bestDailyRank;
	private short bestRank;
	private short victoryCount;
	private short arenaFightcount;
	
	public GameRolePlayArenaUpdatePlayerInfosMessage() {
	}
	
	public GameRolePlayArenaUpdatePlayerInfosMessage(short rank, short bestDailyRank, short bestRank, short victoryCount, short arenaFightcount) {
		this.rank = rank;
		this.bestDailyRank = bestDailyRank;
		this.bestRank = bestRank;
		this.victoryCount = victoryCount;
		this.arenaFightcount = arenaFightcount;
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
		this.rank = reader.readShort();
		if (rank < 0 || rank > 2300)
			throw new IllegalArgumentException(String.format("Forbidden value on rank = %s, it doesn't respect the following condition : rank < 0 || rank > 2300", rank));
		this.bestDailyRank = reader.readShort();
		if (bestDailyRank < 0 || bestDailyRank > 2300)
			throw new IllegalArgumentException(String.format("Forbidden value on bestDailyRank = %s, it doesn't respect the following condition : bestDailyRank < 0 || bestDailyRank > 2300", bestDailyRank));
		this.bestRank = reader.readShort();
		if (bestRank < 0 || bestRank > 2300)
			throw new IllegalArgumentException(String.format("Forbidden value on bestRank = %s, it doesn't respect the following condition : bestRank < 0 || bestRank > 2300", bestRank));
		this.victoryCount = reader.readShort();
		if (victoryCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on victoryCount = %s, it doesn't respect the following condition : victoryCount < 0", victoryCount));
		this.arenaFightcount = reader.readShort();
		if (arenaFightcount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on arenaFightcount = %s, it doesn't respect the following condition : arenaFightcount < 0", arenaFightcount));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.rank);
		writer.writeShort(this.bestDailyRank);
		writer.writeShort(this.bestRank);
		writer.writeShort(this.victoryCount);
		writer.writeShort(this.arenaFightcount);
	}
}