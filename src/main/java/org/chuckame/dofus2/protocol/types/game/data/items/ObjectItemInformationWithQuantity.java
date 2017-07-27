package org.chuckame.dofus2.protocol.types.game.data.items;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.data.items.ObjectItemMinimalInformation;
import org.chuckame.dofus2.protocol.types.game.data.items.effects.ObjectEffect;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ObjectItemInformationWithQuantity extends ObjectItemMinimalInformation {
	public static final short TYPE_ID = 387;
	
	private int quantity;
	
	public ObjectItemInformationWithQuantity() {
	}
	
	public ObjectItemInformationWithQuantity(short objectGID, Collection<ObjectEffect> effects, int quantity) {
		super(objectGID, effects);
		this.quantity = quantity;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.quantity = reader.readInt();
		if (quantity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on quantity = %s, it doesn't respect the following condition : quantity < 0", quantity));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.quantity);
	}
}