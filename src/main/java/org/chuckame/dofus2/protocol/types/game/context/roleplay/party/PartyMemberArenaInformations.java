package org.chuckame.dofus2.protocol.types.game.context.roleplay.party;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.character.status.PlayerStatus;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.party.PartyMemberInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.party.companion.PartyCompanionMemberInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class PartyMemberArenaInformations extends PartyMemberInformations {
	public static final short TYPE_ID = 391;
	
	private short rank;
	
	public PartyMemberArenaInformations() {
	}
	
	public PartyMemberArenaInformations(int id, short level, String name, EntityLook entityLook, byte breed, boolean sex, int lifePoints, int maxLifePoints, short prospecting, short regenRate, short initiative, byte alignmentSide, short worldX, short worldY, int mapId, short subAreaId, PlayerStatus status, Collection<PartyCompanionMemberInformations> companions, short rank) {
		super(id, level, name, entityLook, breed, sex, lifePoints, maxLifePoints, prospecting, regenRate, initiative, alignmentSide, worldX, worldY, mapId, subAreaId, status, companions);
		this.rank = rank;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.rank = reader.readShort();
		if (rank < 0 || rank > 2300)
			throw new IllegalArgumentException(String.format("Forbidden value on rank = %s, it doesn't respect the following condition : rank < 0 || rank > 2300", rank));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.rank);
	}
}