package org.michocko.dofus2.protocol.messages.game.initialization;

import org.michocko.dofus2.protocol.types.game.character.restriction.ActorRestrictionsInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SetCharacterRestrictionsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 170;
	
	private ActorRestrictionsInformations restrictions;
	
	public SetCharacterRestrictionsMessage() {
	}
	
	public SetCharacterRestrictionsMessage(ActorRestrictionsInformations restrictions) {
		this.restrictions = restrictions;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.restrictions = new ActorRestrictionsInformations();
		this.restrictions.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.restrictions.serialize(writer);
	}
}