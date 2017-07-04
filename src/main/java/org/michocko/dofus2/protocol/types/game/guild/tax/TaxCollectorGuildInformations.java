package org.michocko.dofus2.protocol.types.game.guild.tax;

import org.michocko.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;
import org.michocko.dofus2.protocol.types.game.guild.tax.TaxCollectorComplementaryInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class TaxCollectorGuildInformations extends TaxCollectorComplementaryInformations {
	public static final short TYPE_ID = 446;
	
	private BasicGuildInformations guild;
	
	public TaxCollectorGuildInformations() {
	}
	
	public TaxCollectorGuildInformations(BasicGuildInformations guild) {
		this.guild = guild;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.guild = new BasicGuildInformations();
		this.guild.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.guild.serialize(writer);
	}
}