package org.chuckame.dofus2.protocol.messages.game.context.display;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.display.DisplayNumericalValueMessage;

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
	public int getProtocolId() {
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