package org.michocko.dofus2.protocol.messages.game.guild.tax;

import java.util.Collection;
import java.util.LinkedList;

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
public class GuildFightPlayersEnemiesListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5928;
	
	private double fightId;
	private Collection<CharacterMinimalPlusLookInformations> playerInfo;
	
	public GuildFightPlayersEnemiesListMessage() {
	}
	
	public GuildFightPlayersEnemiesListMessage(double fightId, Collection<CharacterMinimalPlusLookInformations> playerInfo) {
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
		int length = reader.readUShort();
		this.playerInfo = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			CharacterMinimalPlusLookInformations entry = new CharacterMinimalPlusLookInformations();
			entry.deserialize(reader);
			this.playerInfo.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.fightId);
		writer.writeUShort(this.playerInfo.size());
		for (CharacterMinimalPlusLookInformations entry : this.playerInfo)
		{
			entry.serialize(writer);
		}
	}
}