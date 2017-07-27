package org.chuckame.dofus2.protocol.messages.game.context.roleplay.spell;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SpellForgetUIMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5565;
	
	private boolean open;
	
	public SpellForgetUIMessage() {
	}
	
	public SpellForgetUIMessage(boolean open) {
		this.open = open;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.open = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.open);
	}
}