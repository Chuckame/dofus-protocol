package org.chuckame.dofus2.protocol.messages.game.character.stats;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.character.characteristic.CharacterCharacteristicsInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CharacterStatsListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 500;
	
	private CharacterCharacteristicsInformations stats;
	
	public CharacterStatsListMessage() {
	}
	
	public CharacterStatsListMessage(CharacterCharacteristicsInformations stats) {
		this.stats = stats;
	}
	
	public int getProtocolId() {
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