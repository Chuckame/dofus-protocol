package org.michocko.dofus2.protocol.messages.game.inventory.items;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeMultiCraftSetCrafterCanUseHisRessourcesMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6021;
	
	private boolean allow;
	
	public ExchangeMultiCraftSetCrafterCanUseHisRessourcesMessage() {
	}
	
	public ExchangeMultiCraftSetCrafterCanUseHisRessourcesMessage(boolean allow) {
		this.allow = allow;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.allow = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.allow);
	}
}