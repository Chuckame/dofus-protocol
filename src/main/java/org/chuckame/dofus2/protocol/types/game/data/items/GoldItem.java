package org.chuckame.dofus2.protocol.types.game.data.items;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.data.items.Item;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GoldItem extends Item {
	public static final short TYPE_ID = 123;
	
	private int sum;
	
	public GoldItem() {
	}
	
	public GoldItem(int sum) {
		this.sum = sum;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.sum = reader.readInt();
		if (sum < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on sum = %s, it doesn't respect the following condition : sum < 0", sum));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.sum);
	}
}