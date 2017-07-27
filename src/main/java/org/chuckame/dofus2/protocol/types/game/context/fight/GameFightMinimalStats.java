package org.chuckame.dofus2.protocol.types.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class GameFightMinimalStats implements INetworkType {
	public static final short TYPE_ID = 31;
	
	private int lifePoints;
	private int maxLifePoints;
	private int baseMaxLifePoints;
	private int permanentDamagePercent;
	private int shieldPoints;
	private short actionPoints;
	private short maxActionPoints;
	private short movementPoints;
	private short maxMovementPoints;
	private int summoner;
	private boolean summoned;
	private short neutralElementResistPercent;
	private short earthElementResistPercent;
	private short waterElementResistPercent;
	private short airElementResistPercent;
	private short fireElementResistPercent;
	private short neutralElementReduction;
	private short earthElementReduction;
	private short waterElementReduction;
	private short airElementReduction;
	private short fireElementReduction;
	private short criticalDamageFixedResist;
	private short pushDamageFixedResist;
	private short dodgePALostProbability;
	private short dodgePMLostProbability;
	private short tackleBlock;
	private short tackleEvade;
	private byte invisibilityState;
	
	public GameFightMinimalStats() {
	}
	
	public GameFightMinimalStats(int lifePoints, int maxLifePoints, int baseMaxLifePoints, int permanentDamagePercent, int shieldPoints, short actionPoints, short maxActionPoints, short movementPoints, short maxMovementPoints, int summoner, boolean summoned, short neutralElementResistPercent, short earthElementResistPercent, short waterElementResistPercent, short airElementResistPercent, short fireElementResistPercent, short neutralElementReduction, short earthElementReduction, short waterElementReduction, short airElementReduction, short fireElementReduction, short criticalDamageFixedResist, short pushDamageFixedResist, short dodgePALostProbability, short dodgePMLostProbability, short tackleBlock, short tackleEvade, byte invisibilityState) {
		this.lifePoints = lifePoints;
		this.maxLifePoints = maxLifePoints;
		this.baseMaxLifePoints = baseMaxLifePoints;
		this.permanentDamagePercent = permanentDamagePercent;
		this.shieldPoints = shieldPoints;
		this.actionPoints = actionPoints;
		this.maxActionPoints = maxActionPoints;
		this.movementPoints = movementPoints;
		this.maxMovementPoints = maxMovementPoints;
		this.summoner = summoner;
		this.summoned = summoned;
		this.neutralElementResistPercent = neutralElementResistPercent;
		this.earthElementResistPercent = earthElementResistPercent;
		this.waterElementResistPercent = waterElementResistPercent;
		this.airElementResistPercent = airElementResistPercent;
		this.fireElementResistPercent = fireElementResistPercent;
		this.neutralElementReduction = neutralElementReduction;
		this.earthElementReduction = earthElementReduction;
		this.waterElementReduction = waterElementReduction;
		this.airElementReduction = airElementReduction;
		this.fireElementReduction = fireElementReduction;
		this.criticalDamageFixedResist = criticalDamageFixedResist;
		this.pushDamageFixedResist = pushDamageFixedResist;
		this.dodgePALostProbability = dodgePALostProbability;
		this.dodgePMLostProbability = dodgePMLostProbability;
		this.tackleBlock = tackleBlock;
		this.tackleEvade = tackleEvade;
		this.invisibilityState = invisibilityState;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.lifePoints = reader.readInt();
		if (lifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lifePoints = %s, it doesn't respect the following condition : lifePoints < 0", lifePoints));
		this.maxLifePoints = reader.readInt();
		if (maxLifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxLifePoints = %s, it doesn't respect the following condition : maxLifePoints < 0", maxLifePoints));
		this.baseMaxLifePoints = reader.readInt();
		if (baseMaxLifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on baseMaxLifePoints = %s, it doesn't respect the following condition : baseMaxLifePoints < 0", baseMaxLifePoints));
		this.permanentDamagePercent = reader.readInt();
		if (permanentDamagePercent < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on permanentDamagePercent = %s, it doesn't respect the following condition : permanentDamagePercent < 0", permanentDamagePercent));
		this.shieldPoints = reader.readInt();
		if (shieldPoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on shieldPoints = %s, it doesn't respect the following condition : shieldPoints < 0", shieldPoints));
		this.actionPoints = reader.readShort();
		this.maxActionPoints = reader.readShort();
		this.movementPoints = reader.readShort();
		this.maxMovementPoints = reader.readShort();
		this.summoner = reader.readInt();
		this.summoned = reader.readBoolean();
		this.neutralElementResistPercent = reader.readShort();
		this.earthElementResistPercent = reader.readShort();
		this.waterElementResistPercent = reader.readShort();
		this.airElementResistPercent = reader.readShort();
		this.fireElementResistPercent = reader.readShort();
		this.neutralElementReduction = reader.readShort();
		this.earthElementReduction = reader.readShort();
		this.waterElementReduction = reader.readShort();
		this.airElementReduction = reader.readShort();
		this.fireElementReduction = reader.readShort();
		this.criticalDamageFixedResist = reader.readShort();
		this.pushDamageFixedResist = reader.readShort();
		this.dodgePALostProbability = reader.readShort();
		if (dodgePALostProbability < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dodgePALostProbability = %s, it doesn't respect the following condition : dodgePALostProbability < 0", dodgePALostProbability));
		this.dodgePMLostProbability = reader.readShort();
		if (dodgePMLostProbability < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dodgePMLostProbability = %s, it doesn't respect the following condition : dodgePMLostProbability < 0", dodgePMLostProbability));
		this.tackleBlock = reader.readShort();
		this.tackleEvade = reader.readShort();
		this.invisibilityState = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.lifePoints);
		writer.writeInt(this.maxLifePoints);
		writer.writeInt(this.baseMaxLifePoints);
		writer.writeInt(this.permanentDamagePercent);
		writer.writeInt(this.shieldPoints);
		writer.writeShort(this.actionPoints);
		writer.writeShort(this.maxActionPoints);
		writer.writeShort(this.movementPoints);
		writer.writeShort(this.maxMovementPoints);
		writer.writeInt(this.summoner);
		writer.writeBoolean(this.summoned);
		writer.writeShort(this.neutralElementResistPercent);
		writer.writeShort(this.earthElementResistPercent);
		writer.writeShort(this.waterElementResistPercent);
		writer.writeShort(this.airElementResistPercent);
		writer.writeShort(this.fireElementResistPercent);
		writer.writeShort(this.neutralElementReduction);
		writer.writeShort(this.earthElementReduction);
		writer.writeShort(this.waterElementReduction);
		writer.writeShort(this.airElementReduction);
		writer.writeShort(this.fireElementReduction);
		writer.writeShort(this.criticalDamageFixedResist);
		writer.writeShort(this.pushDamageFixedResist);
		writer.writeShort(this.dodgePALostProbability);
		writer.writeShort(this.dodgePMLostProbability);
		writer.writeShort(this.tackleBlock);
		writer.writeShort(this.tackleEvade);
		writer.writeSByte(this.invisibilityState);
	}
}