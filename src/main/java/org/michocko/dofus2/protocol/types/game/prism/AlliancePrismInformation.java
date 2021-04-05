package org.michocko.dofus2.protocol.types.game.prism;

import org.michocko.dofus2.protocol.types.game.context.roleplay.AllianceInformations;
import org.michocko.dofus2.protocol.types.game.prism.PrismInformation;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class AlliancePrismInformation extends PrismInformation {
	public static final short TYPE_ID = 427;
	
	private AllianceInformations alliance;
	
	public AlliancePrismInformation() {
	}
	
	public AlliancePrismInformation(byte typeId, byte state, int nextVulnerabilityDate, int placementDate, int rewardTokenCount, AllianceInformations alliance) {
		super(typeId, state, nextVulnerabilityDate, placementDate, rewardTokenCount);
		this.alliance = alliance;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.alliance = new AllianceInformations();
		this.alliance.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.alliance.serialize(writer);
	}
}