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
public class CharacterStatsListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 500;
	
	private CharacterCharacteristicsInformations stats;
	
	public CharacterStatsListMessage() {
	}
	
	public CharacterStatsListMessage(CharacterCharacteristicsInformations stats) {
		this.stats = stats;
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
		this.stats = new CharacterCharacteristicsInformations();
		this.stats.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.stats.serialize(writer);
	}
}