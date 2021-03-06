package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.ObjectItemToSellInNpcShop;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
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