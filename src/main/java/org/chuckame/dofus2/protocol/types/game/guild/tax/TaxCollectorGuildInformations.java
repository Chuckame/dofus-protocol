package org.chuckame.dofus2.protocol.types.game.guild.tax;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;
import org.chuckame.dofus2.protocol.types.game.guild.tax.TaxCollectorComplementaryInformations;

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
	public short getProtocolTypeId() {
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