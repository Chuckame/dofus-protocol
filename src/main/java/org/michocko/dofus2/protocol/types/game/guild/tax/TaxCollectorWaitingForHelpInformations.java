package org.michocko.dofus2.protocol.types.game.guild.tax;

import org.michocko.dofus2.protocol.types.game.fight.ProtectedEntityWaitingForHelpInfo;
import org.michocko.dofus2.protocol.types.game.guild.tax.TaxCollectorComplementaryInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class TaxCollectorWaitingForHelpInformations extends TaxCollectorComplementaryInformations {
	public static final short TYPE_ID = 447;
	
	private ProtectedEntityWaitingForHelpInfo waitingForHelpInfo;
	
	public TaxCollectorWaitingForHelpInformations() {
	}
	
	public TaxCollectorWaitingForHelpInformations(ProtectedEntityWaitingForHelpInfo waitingForHelpInfo) {
		this.waitingForHelpInfo = waitingForHelpInfo;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
		this.waitingForHelpInfo.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.waitingForHelpInfo.serialize(writer);
	}
}