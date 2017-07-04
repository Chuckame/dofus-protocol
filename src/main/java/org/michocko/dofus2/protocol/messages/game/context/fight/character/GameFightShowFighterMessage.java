package org.michocko.dofus2.protocol.messages.game.context.fight.character;

import org.michocko.dofus2.protocol.types.game.context.fight.GameFightFighterInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameFightShowFighterMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5864;
	
	private GameFightFighterInformations informations;
	
	public GameFightShowFighterMessage() {
	}
	
	public GameFightShowFighterMessage(GameFightFighterInformations informations) {
		this.informations = informations;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.informations = ProtocolTypeManager.getInstance().<GameFightFighterInformations>newInstance(reader.readShort());
		this.informations.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.informations.getNetworkTypeId());
		this.informations.serialize(writer);
	}
}