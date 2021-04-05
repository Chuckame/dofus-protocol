package org.michocko.dofus2.protocol.types.game.mount;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.effects.ObjectEffectInteger;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class MountClientData implements INetworkType {
	public static final short TYPE_ID = 178;
	
	private double id;
	private int model;
	private Collection<Integer> ancestor;
	private Collection<Integer> behaviors;
	private String name;
	private int ownerId;
	private double experience;
	private double experienceForLevel;
	private double experienceForNextLevel;
	private byte level;
	private int maxPods;
	private int stamina;
	private int staminaMax;
	private int maturity;
	private int maturityForAdult;
	private int energy;
	private int energyMax;
	private int serenity;
	private int aggressivityMax;
	private int serenityMax;
	private int love;
	private int loveMax;
	private int fecondationTime;
	private int boostLimiter;
	private double boostMax;
	private int reproductionCount;
	private int reproductionCountMax;
	private Collection<ObjectEffectInteger> effectList;
	
	public MountClientData() {
	}
	
	public MountClientData(double id, int model, Collection<Integer> ancestor, Collection<Integer> behaviors, String name, int ownerId, double experience, double experienceForLevel, double experienceForNextLevel, byte level, int maxPods, int stamina, int staminaMax, int maturity, int maturityForAdult, int energy, int energyMax, int serenity, int aggressivityMax, int serenityMax, int love, int loveMax, int fecondationTime, int boostLimiter, double boostMax, int reproductionCount, int reproductionCountMax, Collection<ObjectEffectInteger> effectList) {
		this.id = id;
		this.model = model;
		this.ancestor = ancestor;
		this.behaviors = behaviors;
		this.name = name;
		this.ownerId = ownerId;
		this.experience = experience;
		this.experienceForLevel = experienceForLevel;
		this.experienceForNextLevel = experienceForNextLevel;
		this.level = level;
		this.maxPods = maxPods;
		this.stamina = stamina;
		this.staminaMax = staminaMax;
		this.maturity = maturity;
		this.maturityForAdult = maturityForAdult;
		this.energy = energy;
		this.energyMax = energyMax;
		this.serenity = serenity;
		this.aggressivityMax = aggressivityMax;
		this.serenityMax = serenityMax;
		this.love = love;
		this.loveMax = loveMax;
		this.fecondationTime = fecondationTime;
		this.boostLimiter = boostLimiter;
		this.boostMax = boostMax;
		this.reproductionCount = reproductionCount;
		this.reproductionCountMax = reproductionCountMax;
		this.effectList = effectList;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readDouble();
		this.model = reader.readInt();
		if (model < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on model = %s, it doesn't respect the following condition : model < 0", model));
		int length = reader.readUShort();
		this.ancestor = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.ancestor.add(entry);
		}
		length = reader.readUShort();
		this.behaviors = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.behaviors.add(entry);
		}
		this.name = reader.readUTF();
		this.ownerId = reader.readInt();
		if (ownerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on ownerId = %s, it doesn't respect the following condition : ownerId < 0", ownerId));
		this.experience = reader.readDouble();
		this.experienceForLevel = reader.readDouble();
		this.experienceForNextLevel = reader.readDouble();
		this.level = reader.readSByte();
		if (level < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0", level));
		this.maxPods = reader.readInt();
		if (maxPods < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxPods = %s, it doesn't respect the following condition : maxPods < 0", maxPods));
		this.stamina = reader.readInt();
		if (stamina < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on stamina = %s, it doesn't respect the following condition : stamina < 0", stamina));
		this.staminaMax = reader.readInt();
		if (staminaMax < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on staminaMax = %s, it doesn't respect the following condition : staminaMax < 0", staminaMax));
		this.maturity = reader.readInt();
		if (maturity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maturity = %s, it doesn't respect the following condition : maturity < 0", maturity));
		this.maturityForAdult = reader.readInt();
		if (maturityForAdult < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maturityForAdult = %s, it doesn't respect the following condition : maturityForAdult < 0", maturityForAdult));
		this.energy = reader.readInt();
		if (energy < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on energy = %s, it doesn't respect the following condition : energy < 0", energy));
		this.energyMax = reader.readInt();
		if (energyMax < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on energyMax = %s, it doesn't respect the following condition : energyMax < 0", energyMax));
		this.serenity = reader.readInt();
		this.aggressivityMax = reader.readInt();
		this.serenityMax = reader.readInt();
		if (serenityMax < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on serenityMax = %s, it doesn't respect the following condition : serenityMax < 0", serenityMax));
		this.love = reader.readInt();
		if (love < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on love = %s, it doesn't respect the following condition : love < 0", love));
		this.loveMax = reader.readInt();
		if (loveMax < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on loveMax = %s, it doesn't respect the following condition : loveMax < 0", loveMax));
		this.fecondationTime = reader.readInt();
		this.boostLimiter = reader.readInt();
		if (boostLimiter < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on boostLimiter = %s, it doesn't respect the following condition : boostLimiter < 0", boostLimiter));
		this.boostMax = reader.readDouble();
		this.reproductionCount = reader.readInt();
		this.reproductionCountMax = reader.readInt();
		if (reproductionCountMax < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on reproductionCountMax = %s, it doesn't respect the following condition : reproductionCountMax < 0", reproductionCountMax));
		length = reader.readUShort();
		this.effectList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectEffectInteger entry = new ObjectEffectInteger();
			entry.deserialize(reader);
			this.effectList.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.id);
		writer.writeInt(this.model);
		writer.writeUShort(this.ancestor.size());
		for (int entry : this.ancestor)
		{
			writer.writeInt(entry);
		}
		writer.writeUShort(this.behaviors.size());
		for (int entry : this.behaviors)
		{
			writer.writeInt(entry);
		}
		writer.writeUTF(this.name);
		writer.writeInt(this.ownerId);
		writer.writeDouble(this.experience);
		writer.writeDouble(this.experienceForLevel);
		writer.writeDouble(this.experienceForNextLevel);
		writer.writeSByte(this.level);
		writer.writeInt(this.maxPods);
		writer.writeInt(this.stamina);
		writer.writeInt(this.staminaMax);
		writer.writeInt(this.maturity);
		writer.writeInt(this.maturityForAdult);
		writer.writeInt(this.energy);
		writer.writeInt(this.energyMax);
		writer.writeInt(this.serenity);
		writer.writeInt(this.aggressivityMax);
		writer.writeInt(this.serenityMax);
		writer.writeInt(this.love);
		writer.writeInt(this.loveMax);
		writer.writeInt(this.fecondationTime);
		writer.writeInt(this.boostLimiter);
		writer.writeDouble(this.boostMax);
		writer.writeInt(this.reproductionCount);
		writer.writeInt(this.reproductionCountMax);
		writer.writeUShort(this.effectList.size());
		for (ObjectEffectInteger entry : this.effectList)
		{
			entry.serialize(writer);
		}
	}
}