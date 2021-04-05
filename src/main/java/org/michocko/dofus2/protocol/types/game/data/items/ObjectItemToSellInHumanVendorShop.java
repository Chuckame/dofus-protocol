package org.michocko.dofus2.protocol.types.game.data.items;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.effects.ObjectEffect;
import org.michocko.dofus2.protocol.types.game.data.items.Item;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ObjectItemToSellInHumanVendorShop extends Item {
	public static final short TYPE_ID = 359;
	
	private short objectGID;
	private Collection<ObjectEffect> effects;
	private int objectUID;
	private int quantity;
	private int objectPrice;
	private int publicPrice;
	
	public ObjectItemToSellInHumanVendorShop() {
	}
	
	public ObjectItemToSellInHumanVendorShop(short objectGID, Collection<ObjectEffect> effects, int objectUID, int quantity, int objectPrice, int publicPrice) {
		this.objectGID = objectGID;
		this.effects = effects;
		this.objectUID = objectUID;
		this.quantity = quantity;
		this.objectPrice = objectPrice;
		this.publicPrice = publicPrice;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.objectGID = reader.readShort();
		if (objectGID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectGID = %s, it doesn't respect the following condition : objectGID < 0", objectGID));
		int length = reader.readUShort();
		this.effects = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectEffect entry = (ObjectEffect) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
			entry.deserialize(reader);
			this.effects.add(entry);
		}
		this.objectUID = reader.readInt();
		if (objectUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectUID = %s, it doesn't respect the following condition : objectUID < 0", objectUID));
		this.quantity = reader.readInt();
		if (quantity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on quantity = %s, it doesn't respect the following condition : quantity < 0", quantity));
		this.objectPrice = reader.readInt();
		if (objectPrice < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectPrice = %s, it doesn't respect the following condition : objectPrice < 0", objectPrice));
		this.publicPrice = reader.readInt();
		if (publicPrice < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on publicPrice = %s, it doesn't respect the following condition : publicPrice < 0", publicPrice));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.objectGID);
		writer.writeUShort(this.effects.size());
		for (ObjectEffect entry : this.effects)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
		writer.writeInt(this.objectUID);
		writer.writeInt(this.quantity);
		writer.writeInt(this.objectPrice);
		writer.writeInt(this.publicPrice);
	}
}