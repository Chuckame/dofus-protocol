package org.michocko.dofus2.protocol.messages.game.guild.tax;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildFightPlayersHelpersLeaveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5719;
	
	private double fightId;
	private int playerId;
	
	public GuildFightPlayersHelpersLeaveMessage() {
	}
	
	public GuildFightPlayersHelpersLeaveMessage(double fightId, int playerId) {
		this.fightId = fightId;
		this.playerId = playerId;
	}
	
	public int getNetworkMessageId() {
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