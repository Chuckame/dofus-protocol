package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.social.AbstractSocialGroupInfos;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class BasicAllianceInformations extends AbstractSocialGroupInfos {
	public static final short TYPE_ID = 419;
	
	private int allianceId;
	private String allianceTag;
	
	public BasicAllianceInformations() {
	}
	
	public BasicAllianceInformations(int allianceId, String allianceTag) {
		this.allianceId = allianceId;
		this.allianceTag = allianceTag;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.allianceId = reader.readInt();
		if (allianceId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on allianceId = %s, it doesn't respect the following condition : allianceId < 0", allianceId));
		this.allianceTag = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.allianceId);
		writer.writeUTF(this.allianceTag);
	}
}