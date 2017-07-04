package org.michocko.dofus2.protocol.types.game.context.roleplay;

import org.michocko.dofus2.protocol.types.game.context.roleplay.AllianceInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.HumanOption;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class HumanOptionAlliance extends HumanOption {
	public static final short TYPE_ID = 425;
	
	private AllianceInformations allianceInformations;
	private byte aggressable;
	
	public HumanOptionAlliance() {
	}
	
	public HumanOptionAlliance(AllianceInformations allianceInformations, byte aggressable) {
		this.allianceInformations = allianceInformations;
		this.aggressable = aggressable;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.allianceInformations = new AllianceInformations();
		this.allianceInformations.deserialize(reader);
		this.aggressable = reader.readSByte();
		if (aggressable < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on aggressable = %s, it doesn't respect the following condition : aggressable < 0", aggressable));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.allianceInformations.serialize(writer);
		writer.writeSByte(this.aggressable);
	}
}