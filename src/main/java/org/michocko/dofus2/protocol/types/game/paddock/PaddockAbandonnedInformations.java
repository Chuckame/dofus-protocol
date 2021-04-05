package org.michocko.dofus2.protocol.types.game.paddock;

import org.michocko.dofus2.protocol.types.game.paddock.PaddockBuyableInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class PaddockAbandonnedInformations extends PaddockBuyableInformations {
	public static final short TYPE_ID = 133;
	
	private int guildId;
	
	public PaddockAbandonnedInformations() {
	}
	
	public PaddockAbandonnedInformations(short maxOutdoorMount, short maxItems, int price, boolean locked, int guildId) {
		super(maxOutdoorMount, maxItems, price, locked);
		this.guildId = guildId;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.guildId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.guildId);
	}
}