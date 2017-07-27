package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GuildInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.HumanOption;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class HumanOptionGuild extends HumanOption {
	public static final short TYPE_ID = 409;
	
	private GuildInformations guildInformations;
	
	public HumanOptionGuild() {
	}
	
	public HumanOptionGuild(GuildInformations guildInformations) {
		this.guildInformations = guildInformations;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.guildInformations = new GuildInformations();
		this.guildInformations.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.guildInformations.serialize(writer);
	}
}