package org.michocko.dofus2.protocol.messages.game.context.roleplay.spell;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.open = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.open);
	}
}