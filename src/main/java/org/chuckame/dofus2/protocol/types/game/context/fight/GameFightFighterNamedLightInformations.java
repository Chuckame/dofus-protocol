package org.chuckame.dofus2.protocol.types.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightFighterLightInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameFightFighterNamedLightInformations extends GameFightFighterLightInformations {
	public static final short TYPE_ID = 456;
	
	private String name;
	
	public GameFightFighterNamedLightInformations() {
	}
	
	public GameFightFighterNamedLightInformations(int id, int wave, short level, byte breed, String name) {
		super(id, wave, level, breed);
		this.name = name;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.name = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.name);
	}
}