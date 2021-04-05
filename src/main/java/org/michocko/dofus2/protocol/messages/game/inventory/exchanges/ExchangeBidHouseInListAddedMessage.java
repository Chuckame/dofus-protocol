package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.effects.ObjectEffect;

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
public class ExchangeBidHouseInListAddedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5949;
	
	private int itemUID;
	private int objGenericId;
	private Collection<ObjectEffect> effects;
	private Collection<Integer> prices;
	
	public ExchangeBidHouseInListAddedMessage() {
	}
	
	public ExchangeBidHouseInListAddedMessage(int itemUID, int objGenericId, Collection<ObjectEffect> effects, Collection<Integer> prices) {
		this.itemUID = itemUID;
		this.objGenericId = objGenericId;
		this.effects = effects;
		this.prices = prices;
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
		this.itemUID = reader.readInt();
		this.objGenericId = reader.readInt();
		int length = reader.readUShort();
		this.effects = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectEffect entry = (ObjectEffect) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
			entry.deserialize(reader);
			this.effects.add(entry);
		}
		length = reader.readUShort();
		this.prices = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.prices.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.itemUID);
		writer.writeInt(this.objGenericId);
		writer.writeUShort(this.effects.size());
		for (ObjectEffect entry : this.effects)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
		writer.writeUShort(this.prices.size());
		for (int entry : this.prices)
		{
			writer.writeInt(entry);
		}
	}
}