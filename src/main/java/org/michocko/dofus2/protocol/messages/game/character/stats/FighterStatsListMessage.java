package org.michocko.dofus2.protocol.messages.game.character.stats;

import org.michocko.dofus2.protocol.types.game.character.characteristic.CharacterCharacteristicsInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class FighterStatsListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6322;
	
	private CharacterCharacteristicsInformations stats;
	
	public FighterStatsListMessage() {
	}
	
	public FighterStatsListMessage(CharacterCharacteristicsInformations stats) {
		this.stats = stats;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.stats = new CharacterCharacteristicsInformations();
		this.stats.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.stats.serialize(writer);
	}
}