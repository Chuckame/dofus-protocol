package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicAllianceInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class BasicNamedAllianceInformations extends BasicAllianceInformations {
	public static final short TYPE_ID = 418;
	
	private String allianceName;
	
	public BasicNamedAllianceInformations() {
	}
	
	public BasicNamedAllianceInformations(int allianceId, String allianceTag, String allianceName) {
		super(allianceId, allianceTag);
		this.allianceName = allianceName;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.allianceName = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.allianceName);
	}
}