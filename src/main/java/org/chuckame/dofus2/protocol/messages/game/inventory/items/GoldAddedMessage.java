package org.chuckame.dofus2.protocol.messages.game.inventory.items;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.GoldItem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GoldAddedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6030;
	
	private GoldItem gold;
	
	public GoldAddedMessage() {
	}
	
	public GoldAddedMessage(GoldItem gold) {
		this.gold = gold;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.gold = new GoldItem();
		this.gold.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.gold.serialize(writer);
	}
}