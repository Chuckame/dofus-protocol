package org.chuckame.dofus2.protocol.types.game.mount;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class ItemDurability implements INetworkType {
	public static final short TYPE_ID = 168;
	
	private short durability;
	private short durabilityMax;
	
	public ItemDurability() {
	}
	
	public ItemDurability(short durability, short durabilityMax) {
		this.durability = durability;
		this.durabilityMax = durabilityMax;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.durability = reader.readShort();
		this.durabilityMax = reader.readShort();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.durability);
		writer.writeShort(this.durabilityMax);
	}
}