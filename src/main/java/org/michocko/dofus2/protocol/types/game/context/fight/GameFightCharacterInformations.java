package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.character.alignment.ActorAlignmentInformations;
import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.michocko.dofus2.protocol.types.game.context.fight.GameFightMinimalStats;
import org.michocko.dofus2.protocol.types.game.character.status.PlayerStatus;
import org.michocko.dofus2.protocol.types.game.context.fight.GameFightFighterNamedInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameFightCharacterInformations extends GameFightFighterNamedInformations {
	public static final short TYPE_ID = 46;
	
	private short level;
	private ActorAlignmentInformations alignmentInfos;
	private byte breed;
	
	public GameFightCharacterInformations() {
	}
	
	public GameFightCharacterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, long wave, boolean alive, GameFightMinimalStats stats, String name, PlayerStatus status, short level, ActorAlignmentInformations alignmentInfos, byte breed) {
		super(contextualId, look, disposition, teamId, wave, alive, stats, name, status);
		this.level = level;
		this.alignmentInfos = alignmentInfos;
		this.breed = breed;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.level = reader.readShort();
		if (level < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0", level));
		this.alignmentInfos = new ActorAlignmentInformations();
		this.alignmentInfos.deserialize(reader);
		this.breed = reader.readSByte();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.level);
		this.alignmentInfos.serialize(writer);
		writer.writeSByte(this.breed);
	}
}