package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.ObjectItemToSellInNpcShop;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeStartOkNpcShopMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5761;
	
	private int npcSellerId;
	private int tokenId;
	private Collection<ObjectItemToSellInNpcShop> objectsInfos;
	
	public ExchangeStartOkNpcShopMessage() {
	}
	
	public ExchangeStartOkNpcShopMessage(int npcSellerId, int tokenId, Collection<ObjectItemToSellInNpcShop> objectsInfos) {
		this.npcSellerId = npcSellerId;
		this.tokenId = tokenId;
		this.objectsInfos = objectsInfos;
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
		this.npcSellerId = reader.readInt();
		this.tokenId = reader.readInt();
		if (tokenId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on tokenId = %s, it doesn't respect the following condition : tokenId < 0", tokenId));
		int length = reader.readUShort();
		this.objectsInfos = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItemToSellInNpcShop entry = new ObjectItemToSellInNpcShop();
			entry.deserialize(reader);
			this.objectsInfos.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.npcSellerId);
		writer.writeInt(this.tokenId);
		writer.writeUShort(this.objectsInfos.size());
		for (ObjectItemToSellInNpcShop entry : this.objectsInfos)
		{
			entry.serialize(writer);
		}
	}
}