package org.michocko.dofus2.protocol.messages.game.character.choice;

import org.michocko.dofus2.protocol.types.game.character.choice.CharacterBaseInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	public int getNetworkMessageId() {
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