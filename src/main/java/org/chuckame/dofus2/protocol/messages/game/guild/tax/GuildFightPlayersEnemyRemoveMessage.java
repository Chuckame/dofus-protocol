package org.chuckame.dofus2.protocol.messages.game.guild.tax;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildFightPlayersEnemyRemoveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5929;
	
	private double fightId;
	private int playerId;
	
	public GuildFightPlayersEnemyRemoveMessage() {
	}
	
	public GuildFightPlayersEnemyRemoveMessage(double fightId, int playerId) {
		this.fightId = fightId;
		this.playerId = playerId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightId = reader.readDouble();
		if (fightId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightId = %s, it doesn't respect the following condition : fightId < 0", fightId));
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.fightId);
		writer.writeInt(this.playerId);
	}
}