package org.chuckame.dofus2.protocol.types.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.character.status.PlayerStatus;
import org.chuckame.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightFighterInformations;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightMinimalStats;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameFightFighterNamedInformations extends GameFightFighterInformations {
	public static final short TYPE_ID = 158;
	
	private String name;
	private PlayerStatus status;
	
	public GameFightFighterNamedInformations() {
	}
	
	public GameFightFighterNamedInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, long wave, boolean alive, GameFightMinimalStats stats, String name, PlayerStatus status) {
		super(contextualId, look, disposition, teamId, wave, alive, stats);
		this.name = name;
		this.status = status;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.name = reader.readUTF();
		this.status = new PlayerStatus();
		this.status.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.name);
		this.status.serialize(writer);
	}
}