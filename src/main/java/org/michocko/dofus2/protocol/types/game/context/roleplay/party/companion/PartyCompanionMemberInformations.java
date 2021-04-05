package org.michocko.dofus2.protocol.types.game.context.roleplay.party.companion;

import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.roleplay.party.companion.PartyCompanionBaseInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class PartyCompanionMemberInformations extends PartyCompanionBaseInformations {
	public static final short TYPE_ID = 452;
	
	private short initiative;
	private int lifePoints;
	private int maxLifePoints;
	private short prospecting;
	private short regenRate;
	
	public PartyCompanionMemberInformations() {
	}
	
	public PartyCompanionMemberInformations(byte indexId, short companionGenericId, EntityLook entityLook, short initiative, int lifePoints, int maxLifePoints, short prospecting, short regenRate) {
		super(indexId, companionGenericId, entityLook);
		this.initiative = initiative;
		this.lifePoints = lifePoints;
		this.maxLifePoints = maxLifePoints;
		this.prospecting = prospecting;
		this.regenRate = regenRate;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.initiative = reader.readShort();
		if (initiative < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on initiative = %s, it doesn't respect the following condition : initiative < 0", initiative));
		this.lifePoints = reader.readInt();
		if (lifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lifePoints = %s, it doesn't respect the following condition : lifePoints < 0", lifePoints));
		this.maxLifePoints = reader.readInt();
		if (maxLifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxLifePoints = %s, it doesn't respect the following condition : maxLifePoints < 0", maxLifePoints));
		this.prospecting = reader.readShort();
		if (prospecting < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on prospecting = %s, it doesn't respect the following condition : prospecting < 0", prospecting));
		this.regenRate = reader.readByte();
		if (regenRate < 0 || regenRate > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on regenRate = %s, it doesn't respect the following condition : regenRate < 0 || regenRate > 255", regenRate));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.initiative);
		writer.writeInt(this.lifePoints);
		writer.writeInt(this.maxLifePoints);
		writer.writeShort(this.prospecting);
		writer.writeByte(this.regenRate);
	}
}