package org.michocko.dofus2.protocol.types.game.paddock;

import org.michocko.dofus2.protocol.types.game.paddock.PaddockInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class PaddockBuyableInformations extends PaddockInformations {
	public static final short TYPE_ID = 130;
	
	private int price;
	private boolean locked;
	
	public PaddockBuyableInformations() {
	}
	
	public PaddockBuyableInformations(short maxOutdoorMount, short maxItems, int price, boolean locked) {
		super(maxOutdoorMount, maxItems);
		this.price = price;
		this.locked = locked;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.price = reader.readInt();
		if (price < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on price = %s, it doesn't respect the following condition : price < 0", price));
		this.locked = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.price);
		writer.writeBoolean(this.locked);
	}
}