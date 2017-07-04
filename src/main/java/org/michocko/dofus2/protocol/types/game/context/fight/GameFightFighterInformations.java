package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.context.fight.GameFightMinimalStats;
import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.michocko.dofus2.protocol.types.game.context.GameContextActorInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameFightFighterInformations extends GameContextActorInformations {
	public static final short TYPE_ID = 143;
	
	private byte teamId;
	private long wave;
	private boolean alive;
	private GameFightMinimalStats stats;
	
	public GameFightFighterInformations() {
	}
	
	public GameFightFighterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, long wave, boolean alive, GameFightMinimalStats stats) {
		super(contextualId, look, disposition);
		this.teamId = teamId;
		this.wave = wave;
		this.alive = alive;
		this.stats = stats;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.teamId = reader.readSByte();
		if (teamId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on teamId = %s, it doesn't respect the following condition : teamId < 0", teamId));
		this.wave = reader.readUInt();
		if (wave < 0 || wave > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on wave = %s, it doesn't respect the following condition : wave < 0 || wave > 4.294967295E9", wave));
		this.alive = reader.readBoolean();
		this.stats = ProtocolTypeManager.getInstance().<GameFightMinimalStats>newInstance(reader.readShort());
		this.stats.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.teamId);
		writer.writeUInt(this.wave);
		writer.writeBoolean(this.alive);
		writer.writeShort(this.stats.getNetworkTypeId());
		this.stats.serialize(writer);
	}
}