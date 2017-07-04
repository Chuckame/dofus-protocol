package org.michocko.dofus2.protocol.types.game.data.items;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.effects.ObjectEffect;
import org.michocko.dofus2.protocol.types.game.data.items.ObjectItemMinimalInformation;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ObjectItemToSellInNpcShop extends ObjectItemMinimalInformation {
	public static final short TYPE_ID = 352;
	
	private int objectPrice;
	private String buyCriterion;
	
	public ObjectItemToSellInNpcShop() {
	}
	
	public ObjectItemToSellInNpcShop(short objectGID, Collection<ObjectEffect> effects, int objectPrice, String buyCriterion) {
		super(objectGID, effects);
		this.objectPrice = objectPrice;
		this.buyCriterion = buyCriterion;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.objectPrice = reader.readInt();
		if (objectPrice < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectPrice = %s, it doesn't respect the following condition : objectPrice < 0", objectPrice));
		this.buyCriterion = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.objectPrice);
		writer.writeUTF(this.buyCriterion);
	}
}