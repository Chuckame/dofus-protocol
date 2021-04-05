package org.michocko.dofus2.protocol.messages.game.context.roleplay.paddock;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.paddock.PaddockInformationsForSell;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PaddockToSellListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6138;
	
	private short pageIndex;
	private short totalPage;
	private Collection<PaddockInformationsForSell> paddockList;
	
	public PaddockToSellListMessage() {
	}
	
	public PaddockToSellListMessage(short pageIndex, short totalPage, Collection<PaddockInformationsForSell> paddockList) {
		this.pageIndex = pageIndex;
		this.totalPage = totalPage;
		this.paddockList = paddockList;
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
		this.pageIndex = reader.readShort();
		if (pageIndex < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on pageIndex = %s, it doesn't respect the following condition : pageIndex < 0", pageIndex));
		this.totalPage = reader.readShort();
		if (totalPage < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on totalPage = %s, it doesn't respect the following condition : totalPage < 0", totalPage));
		int length = reader.readUShort();
		this.paddockList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PaddockInformationsForSell entry = new PaddockInformationsForSell();
			entry.deserialize(reader);
			this.paddockList.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.pageIndex);
		writer.writeShort(this.totalPage);
		writer.writeUShort(this.paddockList.size());
		for (PaddockInformationsForSell entry : this.paddockList)
		{
			entry.serialize(writer);
		}
	}
}