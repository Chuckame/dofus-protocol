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
public class BasicGuildInformations extends AbstractSocialGroupInfos {
	public static final short TYPE_ID = 365;
	
	private int guildId;
	private String guildName;
	
	public BasicGuildInformations() {
	}
	
	public BasicGuildInformations(int guildId, String guildName) {
		this.guildId = guildId;
		this.guildName = guildName;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.guildId = reader.readInt();
		if (guildId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on guildId = %s, it doesn't respect the following condition : guildId < 0", guildId));
		this.guildName = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.guildId);
		writer.writeUTF(this.guildName);
	}
}