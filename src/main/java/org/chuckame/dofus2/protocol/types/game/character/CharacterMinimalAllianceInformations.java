package org.chuckame.dofus2.protocol.types.game.character;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.character.CharacterMinimalGuildInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicAllianceInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class CharacterMinimalAllianceInformations extends CharacterMinimalGuildInformations {
	public static final short TYPE_ID = 444;
	
	private BasicAllianceInformations alliance;
	
	public CharacterMinimalAllianceInformations() {
	}
	
	public CharacterMinimalAllianceInformations(int id, short level, String name, EntityLook entityLook, BasicGuildInformations guild, BasicAllianceInformations alliance) {
		super(id, level, name, entityLook, guild);
		this.alliance = alliance;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.alliance = new BasicAllianceInformations();
		this.alliance.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.alliance.serialize(writer);
	}
}