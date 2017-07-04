package org.michocko.dofus2.protocol.messages.game.guild.tax;

import org.michocko.dofus2.protocol.types.game.character.CharacterMinimalPlusLookInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildFightPlayersHelpersJoinMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5720;
	
	private double fightId;
	private CharacterMinimalPlusLookInformations playerInfo;
	
	public GuildFightPlayersHelpersJoinMessage() {
	}
	
	public GuildFightPlayersHelpersJoinMessage(double fightId, CharacterMinimalPlusLookInformations playerInfo) {
		this.fightId = fightId;
		this.playerInfo = playerInfo;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightId = reader.readDouble();
		if (fightId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightId = %s, it doesn't respect the following condition : fightId < 0", fightId));
		this.playerInfo = new CharacterMinimalPlusLookInformations();
		this.playerInfo.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.fightId);
		this.playerInfo.serialize(writer);
	}
}