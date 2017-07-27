package org.chuckame.dofus2.protocol.messages.game.guild;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildInfosUpgradeMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5636;
	
	private byte maxTaxCollectorsCount;
	private byte taxCollectorsCount;
	private short taxCollectorLifePoints;
	private short taxCollectorDamagesBonuses;
	private short taxCollectorPods;
	private short taxCollectorProspecting;
	private short taxCollectorWisdom;
	private short boostPoints;
	private Collection<Short> spellId;
	private Collection<Byte> spellLevel;
	
	public GuildInfosUpgradeMessage() {
	}
	
	public GuildInfosUpgradeMessage(byte maxTaxCollectorsCount, byte taxCollectorsCount, short taxCollectorLifePoints, short taxCollectorDamagesBonuses, short taxCollectorPods, short taxCollectorProspecting, short taxCollectorWisdom, short boostPoints, Collection<Short> spellId, Collection<Byte> spellLevel) {
		this.maxTaxCollectorsCount = maxTaxCollectorsCount;
		this.taxCollectorsCount = taxCollectorsCount;
		this.taxCollectorLifePoints = taxCollectorLifePoints;
		this.taxCollectorDamagesBonuses = taxCollectorDamagesBonuses;
		this.taxCollectorPods = taxCollectorPods;
		this.taxCollectorProspecting = taxCollectorProspecting;
		this.taxCollectorWisdom = taxCollectorWisdom;
		this.boostPoints = boostPoints;
		this.spellId = spellId;
		this.spellLevel = spellLevel;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.maxTaxCollectorsCount = reader.readSByte();
		if (maxTaxCollectorsCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxTaxCollectorsCount = %s, it doesn't respect the following condition : maxTaxCollectorsCount < 0", maxTaxCollectorsCount));
		this.taxCollectorsCount = reader.readSByte();
		if (taxCollectorsCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on taxCollectorsCount = %s, it doesn't respect the following condition : taxCollectorsCount < 0", taxCollectorsCount));
		this.taxCollectorLifePoints = reader.readShort();
		if (taxCollectorLifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on taxCollectorLifePoints = %s, it doesn't respect the following condition : taxCollectorLifePoints < 0", taxCollectorLifePoints));
		this.taxCollectorDamagesBonuses = reader.readShort();
		if (taxCollectorDamagesBonuses < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on taxCollectorDamagesBonuses = %s, it doesn't respect the following condition : taxCollectorDamagesBonuses < 0", taxCollectorDamagesBonuses));
		this.taxCollectorPods = reader.readShort();
		if (taxCollectorPods < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on taxCollectorPods = %s, it doesn't respect the following condition : taxCollectorPods < 0", taxCollectorPods));
		this.taxCollectorProspecting = reader.readShort();
		if (taxCollectorProspecting < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on taxCollectorProspecting = %s, it doesn't respect the following condition : taxCollectorProspecting < 0", taxCollectorProspecting));
		this.taxCollectorWisdom = reader.readShort();
		if (taxCollectorWisdom < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on taxCollectorWisdom = %s, it doesn't respect the following condition : taxCollectorWisdom < 0", taxCollectorWisdom));
		this.boostPoints = reader.readShort();
		if (boostPoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on boostPoints = %s, it doesn't respect the following condition : boostPoints < 0", boostPoints));
		int length = reader.readUShort();
		this.spellId = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.spellId.add(entry);
		}
		length = reader.readUShort();
		this.spellLevel = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			byte entry = reader.readSByte();
			this.spellLevel.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.maxTaxCollectorsCount);
		writer.writeSByte(this.taxCollectorsCount);
		writer.writeShort(this.taxCollectorLifePoints);
		writer.writeShort(this.taxCollectorDamagesBonuses);
		writer.writeShort(this.taxCollectorPods);
		writer.writeShort(this.taxCollectorProspecting);
		writer.writeShort(this.taxCollectorWisdom);
		writer.writeShort(this.boostPoints);
		writer.writeUShort(this.spellId.size());
		for (short entry : this.spellId)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.spellLevel.size());
		for (byte entry : this.spellLevel)
		{
			writer.writeSByte(entry);
		}
	}
}