package org.michocko.dofus2.protocol.messages.game.context.display;

import org.michocko.dofus2.protocol.messages.game.context.display.DisplayNumericalValueMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class DisplayNumericalValueWithAgeBonusMessage extends DisplayNumericalValueMessage {
	public static final int MESSAGE_ID = 6361;
	
	private int valueOfBonus;
	
	public DisplayNumericalValueWithAgeBonusMessage() {
	}
	
	public DisplayNumericalValueWithAgeBonusMessage(int entityId, int value, byte type, int valueOfBonus) {
		super(entityId, value, type);
		this.valueOfBonus = valueOfBonus;
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
		this.valueOfBonus = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.valueOfBonus);
	}
}