package org.chuckame.dofus2.protocol.types.game.guild.tax;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.guild.tax.TaxCollectorComplementaryInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class TaxCollectorLootInformations extends TaxCollectorComplementaryInformations {
	public static final short TYPE_ID = 372;
	
	private int kamas;
	private double experience;
	private int pods;
	private int itemsValue;
	
	public TaxCollectorLootInformations() {
	}
	
	public TaxCollectorLootInformations(int kamas, double experience, int pods, int itemsValue) {
		this.kamas = kamas;
		this.experience = experience;
		this.pods = pods;
		this.itemsValue = itemsValue;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.kamas = reader.readInt();
		if (kamas < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on kamas = %s, it doesn't respect the following condition : kamas < 0", kamas));
		this.experience = reader.readDouble();
		if (experience < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experience = %s, it doesn't respect the following condition : experience < 0", experience));
		this.pods = reader.readInt();
		if (pods < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on pods = %s, it doesn't respect the following condition : pods < 0", pods));
		this.itemsValue = reader.readInt();
		if (itemsValue < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on itemsValue = %s, it doesn't respect the following condition : itemsValue < 0", itemsValue));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.kamas);
		writer.writeDouble(this.experience);
		writer.writeInt(this.pods);
		writer.writeInt(this.itemsValue);
	}
}