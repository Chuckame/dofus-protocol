package org.chuckame.dofus2.protocol.messages.game.character.choice;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.character.choice.CharacterBaseInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CharacterSelectedSuccessMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 153;
	
	private CharacterBaseInformations infos;
	
	public CharacterSelectedSuccessMessage() {
	}
	
	public CharacterSelectedSuccessMessage(CharacterBaseInformations infos) {
		this.infos = infos;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.infos = new CharacterBaseInformations();
		this.infos.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.infos.serialize(writer);
	}
}