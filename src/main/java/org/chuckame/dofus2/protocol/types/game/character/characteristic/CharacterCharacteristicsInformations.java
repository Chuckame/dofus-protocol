package org.chuckame.dofus2.protocol.types.game.character.characteristic;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.protocol.types.game.character.alignment.ActorExtendedAlignmentInformations;
import org.chuckame.dofus2.protocol.types.game.character.characteristic.CharacterBaseCharacteristic;
import org.chuckame.dofus2.protocol.types.game.character.characteristic.CharacterSpellModification;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class CharacterCharacteristicsInformations implements INetworkType {
	public static final short TYPE_ID = 8;
	
	private double experience;
	private double experienceLevelFloor;
	private double experienceNextLevelFloor;
	private int kamas;
	private int statsPoints;
	private int spellsPoints;
	private ActorExtendedAlignmentInformations alignmentInfos;
	private int lifePoints;
	private int maxLifePoints;
	private short energyPoints;
	private short maxEnergyPoints;
	private short actionPointsCurrent;
	private short movementPointsCurrent;
	private CharacterBaseCharacteristic initiative;
	private CharacterBaseCharacteristic prospecting;
	private CharacterBaseCharacteristic actionPoints;
	private CharacterBaseCharacteristic movementPoints;
	private CharacterBaseCharacteristic strength;
	private CharacterBaseCharacteristic vitality;
	private CharacterBaseCharacteristic wisdom;
	private CharacterBaseCharacteristic chance;
	private CharacterBaseCharacteristic agility;
	private CharacterBaseCharacteristic intelligence;
	private CharacterBaseCharacteristic range;
	private CharacterBaseCharacteristic summonableCreaturesBoost;
	private CharacterBaseCharacteristic reflect;
	private CharacterBaseCharacteristic criticalHit;
	private short criticalHitWeapon;
	private CharacterBaseCharacteristic criticalMiss;
	private CharacterBaseCharacteristic healBonus;
	private CharacterBaseCharacteristic allDamagesBonus;
	private CharacterBaseCharacteristic weaponDamagesBonusPercent;
	private CharacterBaseCharacteristic damagesBonusPercent;
	private CharacterBaseCharacteristic trapBonus;
	private CharacterBaseCharacteristic trapBonusPercent;
	private CharacterBaseCharacteristic glyphBonusPercent;
	private CharacterBaseCharacteristic permanentDamagePercent;
	private CharacterBaseCharacteristic tackleBlock;
	private CharacterBaseCharacteristic tackleEvade;
	private CharacterBaseCharacteristic PAAttack;
	private CharacterBaseCharacteristic PMAttack;
	private CharacterBaseCharacteristic pushDamageBonus;
	private CharacterBaseCharacteristic criticalDamageBonus;
	private CharacterBaseCharacteristic neutralDamageBonus;
	private CharacterBaseCharacteristic earthDamageBonus;
	private CharacterBaseCharacteristic waterDamageBonus;
	private CharacterBaseCharacteristic airDamageBonus;
	private CharacterBaseCharacteristic fireDamageBonus;
	private CharacterBaseCharacteristic dodgePALostProbability;
	private CharacterBaseCharacteristic dodgePMLostProbability;
	private CharacterBaseCharacteristic neutralElementResistPercent;
	private CharacterBaseCharacteristic earthElementResistPercent;
	private CharacterBaseCharacteristic waterElementResistPercent;
	private CharacterBaseCharacteristic airElementResistPercent;
	private CharacterBaseCharacteristic fireElementResistPercent;
	private CharacterBaseCharacteristic neutralElementReduction;
	private CharacterBaseCharacteristic earthElementReduction;
	private CharacterBaseCharacteristic waterElementReduction;
	private CharacterBaseCharacteristic airElementReduction;
	private CharacterBaseCharacteristic fireElementReduction;
	private CharacterBaseCharacteristic pushDamageReduction;
	private CharacterBaseCharacteristic criticalDamageReduction;
	private CharacterBaseCharacteristic pvpNeutralElementResistPercent;
	private CharacterBaseCharacteristic pvpEarthElementResistPercent;
	private CharacterBaseCharacteristic pvpWaterElementResistPercent;
	private CharacterBaseCharacteristic pvpAirElementResistPercent;
	private CharacterBaseCharacteristic pvpFireElementResistPercent;
	private CharacterBaseCharacteristic pvpNeutralElementReduction;
	private CharacterBaseCharacteristic pvpEarthElementReduction;
	private CharacterBaseCharacteristic pvpWaterElementReduction;
	private CharacterBaseCharacteristic pvpAirElementReduction;
	private CharacterBaseCharacteristic pvpFireElementReduction;
	private Collection<CharacterSpellModification> spellModifications;
	private int probationTime;
	
	public CharacterCharacteristicsInformations() {
	}
	
	public CharacterCharacteristicsInformations(double experience, double experienceLevelFloor, double experienceNextLevelFloor, int kamas, int statsPoints, int spellsPoints, ActorExtendedAlignmentInformations alignmentInfos, int lifePoints, int maxLifePoints, short energyPoints, short maxEnergyPoints, short actionPointsCurrent, short movementPointsCurrent, CharacterBaseCharacteristic initiative, CharacterBaseCharacteristic prospecting, CharacterBaseCharacteristic actionPoints, CharacterBaseCharacteristic movementPoints, CharacterBaseCharacteristic strength, CharacterBaseCharacteristic vitality, CharacterBaseCharacteristic wisdom, CharacterBaseCharacteristic chance, CharacterBaseCharacteristic agility, CharacterBaseCharacteristic intelligence, CharacterBaseCharacteristic range, CharacterBaseCharacteristic summonableCreaturesBoost, CharacterBaseCharacteristic reflect, CharacterBaseCharacteristic criticalHit, short criticalHitWeapon, CharacterBaseCharacteristic criticalMiss, CharacterBaseCharacteristic healBonus, CharacterBaseCharacteristic allDamagesBonus, CharacterBaseCharacteristic weaponDamagesBonusPercent, CharacterBaseCharacteristic damagesBonusPercent, CharacterBaseCharacteristic trapBonus, CharacterBaseCharacteristic trapBonusPercent, CharacterBaseCharacteristic glyphBonusPercent, CharacterBaseCharacteristic permanentDamagePercent, CharacterBaseCharacteristic tackleBlock, CharacterBaseCharacteristic tackleEvade, CharacterBaseCharacteristic PAAttack, CharacterBaseCharacteristic PMAttack, CharacterBaseCharacteristic pushDamageBonus, CharacterBaseCharacteristic criticalDamageBonus, CharacterBaseCharacteristic neutralDamageBonus, CharacterBaseCharacteristic earthDamageBonus, CharacterBaseCharacteristic waterDamageBonus, CharacterBaseCharacteristic airDamageBonus, CharacterBaseCharacteristic fireDamageBonus, CharacterBaseCharacteristic dodgePALostProbability, CharacterBaseCharacteristic dodgePMLostProbability, CharacterBaseCharacteristic neutralElementResistPercent, CharacterBaseCharacteristic earthElementResistPercent, CharacterBaseCharacteristic waterElementResistPercent, CharacterBaseCharacteristic airElementResistPercent, CharacterBaseCharacteristic fireElementResistPercent, CharacterBaseCharacteristic neutralElementReduction, CharacterBaseCharacteristic earthElementReduction, CharacterBaseCharacteristic waterElementReduction, CharacterBaseCharacteristic airElementReduction, CharacterBaseCharacteristic fireElementReduction, CharacterBaseCharacteristic pushDamageReduction, CharacterBaseCharacteristic criticalDamageReduction, CharacterBaseCharacteristic pvpNeutralElementResistPercent, CharacterBaseCharacteristic pvpEarthElementResistPercent, CharacterBaseCharacteristic pvpWaterElementResistPercent, CharacterBaseCharacteristic pvpAirElementResistPercent, CharacterBaseCharacteristic pvpFireElementResistPercent, CharacterBaseCharacteristic pvpNeutralElementReduction, CharacterBaseCharacteristic pvpEarthElementReduction, CharacterBaseCharacteristic pvpWaterElementReduction, CharacterBaseCharacteristic pvpAirElementReduction, CharacterBaseCharacteristic pvpFireElementReduction, Collection<CharacterSpellModification> spellModifications, int probationTime) {
		this.experience = experience;
		this.experienceLevelFloor = experienceLevelFloor;
		this.experienceNextLevelFloor = experienceNextLevelFloor;
		this.kamas = kamas;
		this.statsPoints = statsPoints;
		this.spellsPoints = spellsPoints;
		this.alignmentInfos = alignmentInfos;
		this.lifePoints = lifePoints;
		this.maxLifePoints = maxLifePoints;
		this.energyPoints = energyPoints;
		this.maxEnergyPoints = maxEnergyPoints;
		this.actionPointsCurrent = actionPointsCurrent;
		this.movementPointsCurrent = movementPointsCurrent;
		this.initiative = initiative;
		this.prospecting = prospecting;
		this.actionPoints = actionPoints;
		this.movementPoints = movementPoints;
		this.strength = strength;
		this.vitality = vitality;
		this.wisdom = wisdom;
		this.chance = chance;
		this.agility = agility;
		this.intelligence = intelligence;
		this.range = range;
		this.summonableCreaturesBoost = summonableCreaturesBoost;
		this.reflect = reflect;
		this.criticalHit = criticalHit;
		this.criticalHitWeapon = criticalHitWeapon;
		this.criticalMiss = criticalMiss;
		this.healBonus = healBonus;
		this.allDamagesBonus = allDamagesBonus;
		this.weaponDamagesBonusPercent = weaponDamagesBonusPercent;
		this.damagesBonusPercent = damagesBonusPercent;
		this.trapBonus = trapBonus;
		this.trapBonusPercent = trapBonusPercent;
		this.glyphBonusPercent = glyphBonusPercent;
		this.permanentDamagePercent = permanentDamagePercent;
		this.tackleBlock = tackleBlock;
		this.tackleEvade = tackleEvade;
		this.PAAttack = PAAttack;
		this.PMAttack = PMAttack;
		this.pushDamageBonus = pushDamageBonus;
		this.criticalDamageBonus = criticalDamageBonus;
		this.neutralDamageBonus = neutralDamageBonus;
		this.earthDamageBonus = earthDamageBonus;
		this.waterDamageBonus = waterDamageBonus;
		this.airDamageBonus = airDamageBonus;
		this.fireDamageBonus = fireDamageBonus;
		this.dodgePALostProbability = dodgePALostProbability;
		this.dodgePMLostProbability = dodgePMLostProbability;
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
		this.pushDamageReduction = pushDamageReduction;
		this.criticalDamageReduction = criticalDamageReduction;
		this.pvpNeutralElementResistPercent = pvpNeutralElementResistPercent;
		this.pvpEarthElementResistPercent = pvpEarthElementResistPercent;
		this.pvpWaterElementResistPercent = pvpWaterElementResistPercent;
		this.pvpAirElementResistPercent = pvpAirElementResistPercent;
		this.pvpFireElementResistPercent = pvpFireElementResistPercent;
		this.pvpNeutralElementReduction = pvpNeutralElementReduction;
		this.pvpEarthElementReduction = pvpEarthElementReduction;
		this.pvpWaterElementReduction = pvpWaterElementReduction;
		this.pvpAirElementReduction = pvpAirElementReduction;
		this.pvpFireElementReduction = pvpFireElementReduction;
		this.spellModifications = spellModifications;
		this.probationTime = probationTime;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.experience = reader.readDouble();
		if (experience < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experience = %s, it doesn't respect the following condition : experience < 0", experience));
		this.experienceLevelFloor = reader.readDouble();
		if (experienceLevelFloor < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experienceLevelFloor = %s, it doesn't respect the following condition : experienceLevelFloor < 0", experienceLevelFloor));
		this.experienceNextLevelFloor = reader.readDouble();
		if (experienceNextLevelFloor < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experienceNextLevelFloor = %s, it doesn't respect the following condition : experienceNextLevelFloor < 0", experienceNextLevelFloor));
		this.kamas = reader.readInt();
		if (kamas < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on kamas = %s, it doesn't respect the following condition : kamas < 0", kamas));
		this.statsPoints = reader.readInt();
		if (statsPoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on statsPoints = %s, it doesn't respect the following condition : statsPoints < 0", statsPoints));
		this.spellsPoints = reader.readInt();
		if (spellsPoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellsPoints = %s, it doesn't respect the following condition : spellsPoints < 0", spellsPoints));
		this.alignmentInfos = new ActorExtendedAlignmentInformations();
		this.alignmentInfos.deserialize(reader);
		this.lifePoints = reader.readInt();
		if (lifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lifePoints = %s, it doesn't respect the following condition : lifePoints < 0", lifePoints));
		this.maxLifePoints = reader.readInt();
		if (maxLifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxLifePoints = %s, it doesn't respect the following condition : maxLifePoints < 0", maxLifePoints));
		this.energyPoints = reader.readShort();
		if (energyPoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on energyPoints = %s, it doesn't respect the following condition : energyPoints < 0", energyPoints));
		this.maxEnergyPoints = reader.readShort();
		if (maxEnergyPoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxEnergyPoints = %s, it doesn't respect the following condition : maxEnergyPoints < 0", maxEnergyPoints));
		this.actionPointsCurrent = reader.readShort();
		this.movementPointsCurrent = reader.readShort();
		this.initiative = new CharacterBaseCharacteristic();
		this.initiative.deserialize(reader);
		this.prospecting = new CharacterBaseCharacteristic();
		this.prospecting.deserialize(reader);
		this.actionPoints = new CharacterBaseCharacteristic();
		this.actionPoints.deserialize(reader);
		this.movementPoints = new CharacterBaseCharacteristic();
		this.movementPoints.deserialize(reader);
		this.strength = new CharacterBaseCharacteristic();
		this.strength.deserialize(reader);
		this.vitality = new CharacterBaseCharacteristic();
		this.vitality.deserialize(reader);
		this.wisdom = new CharacterBaseCharacteristic();
		this.wisdom.deserialize(reader);
		this.chance = new CharacterBaseCharacteristic();
		this.chance.deserialize(reader);
		this.agility = new CharacterBaseCharacteristic();
		this.agility.deserialize(reader);
		this.intelligence = new CharacterBaseCharacteristic();
		this.intelligence.deserialize(reader);
		this.range = new CharacterBaseCharacteristic();
		this.range.deserialize(reader);
		this.summonableCreaturesBoost = new CharacterBaseCharacteristic();
		this.summonableCreaturesBoost.deserialize(reader);
		this.reflect = new CharacterBaseCharacteristic();
		this.reflect.deserialize(reader);
		this.criticalHit = new CharacterBaseCharacteristic();
		this.criticalHit.deserialize(reader);
		this.criticalHitWeapon = reader.readShort();
		if (criticalHitWeapon < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on criticalHitWeapon = %s, it doesn't respect the following condition : criticalHitWeapon < 0", criticalHitWeapon));
		this.criticalMiss = new CharacterBaseCharacteristic();
		this.criticalMiss.deserialize(reader);
		this.healBonus = new CharacterBaseCharacteristic();
		this.healBonus.deserialize(reader);
		this.allDamagesBonus = new CharacterBaseCharacteristic();
		this.allDamagesBonus.deserialize(reader);
		this.weaponDamagesBonusPercent = new CharacterBaseCharacteristic();
		this.weaponDamagesBonusPercent.deserialize(reader);
		this.damagesBonusPercent = new CharacterBaseCharacteristic();
		this.damagesBonusPercent.deserialize(reader);
		this.trapBonus = new CharacterBaseCharacteristic();
		this.trapBonus.deserialize(reader);
		this.trapBonusPercent = new CharacterBaseCharacteristic();
		this.trapBonusPercent.deserialize(reader);
		this.glyphBonusPercent = new CharacterBaseCharacteristic();
		this.glyphBonusPercent.deserialize(reader);
		this.permanentDamagePercent = new CharacterBaseCharacteristic();
		this.permanentDamagePercent.deserialize(reader);
		this.tackleBlock = new CharacterBaseCharacteristic();
		this.tackleBlock.deserialize(reader);
		this.tackleEvade = new CharacterBaseCharacteristic();
		this.tackleEvade.deserialize(reader);
		this.PAAttack = new CharacterBaseCharacteristic();
		this.PAAttack.deserialize(reader);
		this.PMAttack = new CharacterBaseCharacteristic();
		this.PMAttack.deserialize(reader);
		this.pushDamageBonus = new CharacterBaseCharacteristic();
		this.pushDamageBonus.deserialize(reader);
		this.criticalDamageBonus = new CharacterBaseCharacteristic();
		this.criticalDamageBonus.deserialize(reader);
		this.neutralDamageBonus = new CharacterBaseCharacteristic();
		this.neutralDamageBonus.deserialize(reader);
		this.earthDamageBonus = new CharacterBaseCharacteristic();
		this.earthDamageBonus.deserialize(reader);
		this.waterDamageBonus = new CharacterBaseCharacteristic();
		this.waterDamageBonus.deserialize(reader);
		this.airDamageBonus = new CharacterBaseCharacteristic();
		this.airDamageBonus.deserialize(reader);
		this.fireDamageBonus = new CharacterBaseCharacteristic();
		this.fireDamageBonus.deserialize(reader);
		this.dodgePALostProbability = new CharacterBaseCharacteristic();
		this.dodgePALostProbability.deserialize(reader);
		this.dodgePMLostProbability = new CharacterBaseCharacteristic();
		this.dodgePMLostProbability.deserialize(reader);
		this.neutralElementResistPercent = new CharacterBaseCharacteristic();
		this.neutralElementResistPercent.deserialize(reader);
		this.earthElementResistPercent = new CharacterBaseCharacteristic();
		this.earthElementResistPercent.deserialize(reader);
		this.waterElementResistPercent = new CharacterBaseCharacteristic();
		this.waterElementResistPercent.deserialize(reader);
		this.airElementResistPercent = new CharacterBaseCharacteristic();
		this.airElementResistPercent.deserialize(reader);
		this.fireElementResistPercent = new CharacterBaseCharacteristic();
		this.fireElementResistPercent.deserialize(reader);
		this.neutralElementReduction = new CharacterBaseCharacteristic();
		this.neutralElementReduction.deserialize(reader);
		this.earthElementReduction = new CharacterBaseCharacteristic();
		this.earthElementReduction.deserialize(reader);
		this.waterElementReduction = new CharacterBaseCharacteristic();
		this.waterElementReduction.deserialize(reader);
		this.airElementReduction = new CharacterBaseCharacteristic();
		this.airElementReduction.deserialize(reader);
		this.fireElementReduction = new CharacterBaseCharacteristic();
		this.fireElementReduction.deserialize(reader);
		this.pushDamageReduction = new CharacterBaseCharacteristic();
		this.pushDamageReduction.deserialize(reader);
		this.criticalDamageReduction = new CharacterBaseCharacteristic();
		this.criticalDamageReduction.deserialize(reader);
		this.pvpNeutralElementResistPercent = new CharacterBaseCharacteristic();
		this.pvpNeutralElementResistPercent.deserialize(reader);
		this.pvpEarthElementResistPercent = new CharacterBaseCharacteristic();
		this.pvpEarthElementResistPercent.deserialize(reader);
		this.pvpWaterElementResistPercent = new CharacterBaseCharacteristic();
		this.pvpWaterElementResistPercent.deserialize(reader);
		this.pvpAirElementResistPercent = new CharacterBaseCharacteristic();
		this.pvpAirElementResistPercent.deserialize(reader);
		this.pvpFireElementResistPercent = new CharacterBaseCharacteristic();
		this.pvpFireElementResistPercent.deserialize(reader);
		this.pvpNeutralElementReduction = new CharacterBaseCharacteristic();
		this.pvpNeutralElementReduction.deserialize(reader);
		this.pvpEarthElementReduction = new CharacterBaseCharacteristic();
		this.pvpEarthElementReduction.deserialize(reader);
		this.pvpWaterElementReduction = new CharacterBaseCharacteristic();
		this.pvpWaterElementReduction.deserialize(reader);
		this.pvpAirElementReduction = new CharacterBaseCharacteristic();
		this.pvpAirElementReduction.deserialize(reader);
		this.pvpFireElementReduction = new CharacterBaseCharacteristic();
		this.pvpFireElementReduction.deserialize(reader);
		int length = reader.readUShort();
		this.spellModifications = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			CharacterSpellModification entry = new CharacterSpellModification();
			entry.deserialize(reader);
			this.spellModifications.add(entry);
		}
		this.probationTime = reader.readInt();
		if (probationTime < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on probationTime = %s, it doesn't respect the following condition : probationTime < 0", probationTime));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.experience);
		writer.writeDouble(this.experienceLevelFloor);
		writer.writeDouble(this.experienceNextLevelFloor);
		writer.writeInt(this.kamas);
		writer.writeInt(this.statsPoints);
		writer.writeInt(this.spellsPoints);
		this.alignmentInfos.serialize(writer);
		writer.writeInt(this.lifePoints);
		writer.writeInt(this.maxLifePoints);
		writer.writeShort(this.energyPoints);
		writer.writeShort(this.maxEnergyPoints);
		writer.writeShort(this.actionPointsCurrent);
		writer.writeShort(this.movementPointsCurrent);
		this.initiative.serialize(writer);
		this.prospecting.serialize(writer);
		this.actionPoints.serialize(writer);
		this.movementPoints.serialize(writer);
		this.strength.serialize(writer);
		this.vitality.serialize(writer);
		this.wisdom.serialize(writer);
		this.chance.serialize(writer);
		this.agility.serialize(writer);
		this.intelligence.serialize(writer);
		this.range.serialize(writer);
		this.summonableCreaturesBoost.serialize(writer);
		this.reflect.serialize(writer);
		this.criticalHit.serialize(writer);
		writer.writeShort(this.criticalHitWeapon);
		this.criticalMiss.serialize(writer);
		this.healBonus.serialize(writer);
		this.allDamagesBonus.serialize(writer);
		this.weaponDamagesBonusPercent.serialize(writer);
		this.damagesBonusPercent.serialize(writer);
		this.trapBonus.serialize(writer);
		this.trapBonusPercent.serialize(writer);
		this.glyphBonusPercent.serialize(writer);
		this.permanentDamagePercent.serialize(writer);
		this.tackleBlock.serialize(writer);
		this.tackleEvade.serialize(writer);
		this.PAAttack.serialize(writer);
		this.PMAttack.serialize(writer);
		this.pushDamageBonus.serialize(writer);
		this.criticalDamageBonus.serialize(writer);
		this.neutralDamageBonus.serialize(writer);
		this.earthDamageBonus.serialize(writer);
		this.waterDamageBonus.serialize(writer);
		this.airDamageBonus.serialize(writer);
		this.fireDamageBonus.serialize(writer);
		this.dodgePALostProbability.serialize(writer);
		this.dodgePMLostProbability.serialize(writer);
		this.neutralElementResistPercent.serialize(writer);
		this.earthElementResistPercent.serialize(writer);
		this.waterElementResistPercent.serialize(writer);
		this.airElementResistPercent.serialize(writer);
		this.fireElementResistPercent.serialize(writer);
		this.neutralElementReduction.serialize(writer);
		this.earthElementReduction.serialize(writer);
		this.waterElementReduction.serialize(writer);
		this.airElementReduction.serialize(writer);
		this.fireElementReduction.serialize(writer);
		this.pushDamageReduction.serialize(writer);
		this.criticalDamageReduction.serialize(writer);
		this.pvpNeutralElementResistPercent.serialize(writer);
		this.pvpEarthElementResistPercent.serialize(writer);
		this.pvpWaterElementResistPercent.serialize(writer);
		this.pvpAirElementResistPercent.serialize(writer);
		this.pvpFireElementResistPercent.serialize(writer);
		this.pvpNeutralElementReduction.serialize(writer);
		this.pvpEarthElementReduction.serialize(writer);
		this.pvpWaterElementReduction.serialize(writer);
		this.pvpAirElementReduction.serialize(writer);
		this.pvpFireElementReduction.serialize(writer);
		writer.writeUShort(this.spellModifications.size());
		for (CharacterSpellModification entry : this.spellModifications)
		{
			entry.serialize(writer);
		}
		writer.writeInt(this.probationTime);
	}
}