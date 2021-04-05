package org.michocko.dofus2.protocol.messages.game.inventory.items;

import org.michocko.dofus2.protocol.types.game.data.items.GoldItem;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.gold = new GoldItem();
		this.gold.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.gold.serialize(writer);
	}
}