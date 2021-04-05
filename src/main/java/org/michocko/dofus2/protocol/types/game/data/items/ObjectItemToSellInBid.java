package org.michocko.dofus2.protocol.types.game.data.items;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.effects.ObjectEffect;
import org.michocko.dofus2.protocol.types.game.data.items.ObjectItemToSell;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ObjectItemToSellInBid extends ObjectItemToSell {
	public static final short TYPE_ID = 164;
	
	private int unsoldDelay;
	
	public ObjectItemToSellInBid() {
	}
	
	public ObjectItemToSellInBid(short objectGID, Collection<ObjectEffect> effects, int objectUID, int quantity, int objectPrice, int unsoldDelay) {
		super(objectGID, effects, objectUID, quantity, objectPrice);
		this.unsoldDelay = unsoldDelay;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.unsoldDelay = reader.readInt();
		if (unsoldDelay < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on unsoldDelay = %s, it doesn't respect the following condition : unsoldDelay < 0", unsoldDelay));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.unsoldDelay);
	}
}