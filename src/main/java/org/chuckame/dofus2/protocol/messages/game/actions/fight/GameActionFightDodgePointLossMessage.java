package org.chuckame.dofus2.protocol.messages.game.actions.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.actions.AbstractGameActionMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightDodgePointLossMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5828;
	
	private int targetId;
	private short amount;
	
	public GameActionFightDodgePointLossMessage() {
	}
	
	public GameActionFightDodgePointLossMessage(short actionId, int sourceId, int targetId, short amount) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.amount = amount;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.targetId = reader.readInt();
		this.amount = reader.readShort();
		if (amount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on amount = %s, it doesn't respect the following condition : amount < 0", amount));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		writer.writeShort(this.amount);
	}
}