package org.michocko.dofus2.protocol.types.game.character;

import org.michocko.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;
import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.character.CharacterMinimalPlusLookInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class CharacterMinimalGuildInformations extends CharacterMinimalPlusLookInformations {
	public static final short TYPE_ID = 445;
	
	private BasicGuildInformations guild;
	
	public CharacterMinimalGuildInformations() {
	}
	
	public CharacterMinimalGuildInformations(int id, short level, String name, EntityLook entityLook, BasicGuildInformations guild) {
		super(id, level, name, entityLook);
		this.guild = guild;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.guild = new BasicGuildInformations();
		this.guild.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.guild.serialize(writer);
	}
}