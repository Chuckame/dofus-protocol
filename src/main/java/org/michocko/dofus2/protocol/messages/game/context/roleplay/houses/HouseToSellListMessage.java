package org.michocko.dofus2.protocol.messages.game.context.roleplay.houses;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.house.HouseInformationsForSell;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class HouseToSellListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6140;
	
	private short pageIndex;
	private short totalPage;
	private Collection<HouseInformationsForSell> houseList;
	
	public HouseToSellListMessage() {
	}
	
	public HouseToSellListMessage(short pageIndex, short totalPage, Collection<HouseInformationsForSell> houseList) {
		this.pageIndex = pageIndex;
		this.totalPage = totalPage;
		this.houseList = houseList;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.pageIndex = reader.readShort();
		if (pageIndex < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on pageIndex = %s, it doesn't respect the following condition : pageIndex < 0", pageIndex));
		this.totalPage = reader.readShort();
		if (totalPage < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on totalPage = %s, it doesn't respect the following condition : totalPage < 0", totalPage));
		int length = reader.readUShort();
		this.houseList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			HouseInformationsForSell entry = new HouseInformationsForSell();
			entry.deserialize(reader);
			this.houseList.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.pageIndex);
		writer.writeShort(this.totalPage);
		writer.writeUShort(this.houseList.size());
		for (HouseInformationsForSell entry : this.houseList)
		{
			entry.serialize(writer);
		}
	}
}