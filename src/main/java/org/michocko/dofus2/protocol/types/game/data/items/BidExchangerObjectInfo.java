package org.michocko.dofus2.protocol.types.game.data.items;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.effects.ObjectEffect;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class BidExchangerObjectInfo implements INetworkType {
	public static final short TYPE_ID = 122;
	
	private int objectUID;
	private Collection<ObjectEffect> effects;
	private Collection<Integer> prices;
	
	public BidExchangerObjectInfo() {
	}
	
	public BidExchangerObjectInfo(int objectUID, Collection<ObjectEffect> effects, Collection<Integer> prices) {
		this.objectUID = objectUID;
		this.effects = effects;
		this.prices = prices;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.objectUID = reader.readInt();
		if (objectUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectUID = %s, it doesn't respect the following condition : objectUID < 0", objectUID));
		int length = reader.readUShort();
		this.effects = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectEffect entry = ProtocolTypeManager.getInstance().<ObjectEffect>newInstance(reader.readShort());
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
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objectUID);
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