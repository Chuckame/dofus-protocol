package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.effects.ObjectEffect;
import org.michocko.dofus2.protocol.messages.game.inventory.exchanges.ExchangeBidHouseInListAddedMessage;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeBidHouseInListUpdatedMessage extends ExchangeBidHouseInListAddedMessage {
	public static final int MESSAGE_ID = 6337;
	
	
	public ExchangeBidHouseInListUpdatedMessage() {
	}
	
	public ExchangeBidHouseInListUpdatedMessage(int itemUID, int objGenericId, Collection<ObjectEffect> effects, Collection<Integer> prices) {
		super(itemUID, objGenericId, effects, prices);
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
		super.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}