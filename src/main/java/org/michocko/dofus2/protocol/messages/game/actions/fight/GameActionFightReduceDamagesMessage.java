package org.michocko.dofus2.protocol.messages.game.actions.fight;

import org.michocko.dofus2.protocol.messages.game.actions.AbstractGameActionMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightReduceDamagesMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5526;
	
	private int targetId;
	private int amount;
	
	public GameActionFightReduceDamagesMessage() {
	}
	
	public GameActionFightReduceDamagesMessage(short actionId, int sourceId, int targetId, int amount) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.amount = amount;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.targetId = reader.readInt();
		this.amount = reader.readInt();
		if (amount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on amount = %s, it doesn't respect the following condition : amount < 0", amount));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		writer.writeInt(this.amount);
	}
}