package org.chuckame.dofus2.protocol.types.game.social;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.AllianceInformations;
import org.chuckame.dofus2.protocol.types.game.guild.GuildEmblem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class AllianceFactSheetInformations extends AllianceInformations {
	public static final short TYPE_ID = 421;
	
	private int creationDate;
	
	public AllianceFactSheetInformations() {
	}
	
	public AllianceFactSheetInformations(int allianceId, String allianceTag, String allianceName, GuildEmblem allianceEmblem, int creationDate) {
		super(allianceId, allianceTag, allianceName, allianceEmblem);
		this.creationDate = creationDate;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.creationDate = reader.readInt();
		if (creationDate < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on creationDate = %s, it doesn't respect the following condition : creationDate < 0", creationDate));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.creationDate);
	}
}