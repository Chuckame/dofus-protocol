package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicNamedAllianceInformations;
import org.chuckame.dofus2.protocol.types.game.guild.GuildEmblem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class AllianceInformations extends BasicNamedAllianceInformations {
	public static final short TYPE_ID = 417;
	
	private GuildEmblem allianceEmblem;
	
	public AllianceInformations() {
	}
	
	public AllianceInformations(int allianceId, String allianceTag, String allianceName, GuildEmblem allianceEmblem) {
		super(allianceId, allianceTag, allianceName);
		this.allianceEmblem = allianceEmblem;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.allianceEmblem = new GuildEmblem();
		this.allianceEmblem.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.allianceEmblem.serialize(writer);
	}
}