package org.michocko.dofus2.protocol.messages.game.context.roleplay.npc;

import org.michocko.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;
import org.michocko.dofus2.protocol.messages.game.context.roleplay.npc.TaxCollectorDialogQuestionBasicMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class TaxCollectorDialogQuestionExtendedMessage extends TaxCollectorDialogQuestionBasicMessage {
	public static final int MESSAGE_ID = 5615;
	
	private short maxPods;
	private short prospecting;
	private short wisdom;
	private byte taxCollectorsCount;
	private int taxCollectorAttack;
	private int kamas;
	private double experience;
	private int pods;
	private int itemsValue;
	
	public TaxCollectorDialogQuestionExtendedMessage() {
	}
	
	public TaxCollectorDialogQuestionExtendedMessage(BasicGuildInformations guildInfo, short maxPods, short prospecting, short wisdom, byte taxCollectorsCount, int taxCollectorAttack, int kamas, double experience, int pods, int itemsValue) {
		super(guildInfo);
		this.maxPods = maxPods;
		this.prospecting = prospecting;
		this.wisdom = wisdom;
		this.taxCollectorsCount = taxCollectorsCount;
		this.taxCollectorAttack = taxCollectorAttack;
		this.kamas = kamas;
		this.experience = experience;
		this.pods = pods;
		this.itemsValue = itemsValue;
	}
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.maxPods = reader.readShort();
		if (maxPods < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxPods = %s, it doesn't respect the following condition : maxPods < 0", maxPods));
		this.prospecting = reader.readShort();
		if (prospecting < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on prospecting = %s, it doesn't respect the following condition : prospecting < 0", prospecting));
		this.wisdom = reader.readShort();
		if (wisdom < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on wisdom = %s, it doesn't respect the following condition : wisdom < 0", wisdom));
		this.taxCollectorsCount = reader.readSByte();
		if (taxCollectorsCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on taxCollectorsCount = %s, it doesn't respect the following condition : taxCollectorsCount < 0", taxCollectorsCount));
		this.taxCollectorAttack = reader.readInt();
		this.kamas = reader.readInt();
		if (kamas < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on kamas = %s, it doesn't respect the following condition : kamas < 0", kamas));
		this.experience = reader.readDouble();
		if (experience < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experience = %s, it doesn't respect the following condition : experience < 0", experience));
		this.pods = reader.readInt();
		if (pods < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on pods = %s, it doesn't respect the following condition : pods < 0", pods));
		this.itemsValue = reader.readInt();
		if (itemsValue < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on itemsValue = %s, it doesn't respect the following condition : itemsValue < 0", itemsValue));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.maxPods);
		writer.writeShort(this.prospecting);
		writer.writeShort(this.wisdom);
		writer.writeSByte(this.taxCollectorsCount);
		writer.writeInt(this.taxCollectorAttack);
		writer.writeInt(this.kamas);
		writer.writeDouble(this.experience);
		writer.writeInt(this.pods);
		writer.writeInt(this.itemsValue);
	}
}