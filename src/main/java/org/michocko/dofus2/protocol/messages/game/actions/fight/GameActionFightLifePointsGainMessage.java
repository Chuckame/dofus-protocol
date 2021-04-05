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
public class GameActionFightLifePointsGainMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 6311;
	
	private int targetId;
	private short delta;
	
	public GameActionFightLifePointsGainMessage() {
	}
	
	public GameActionFightLifePointsGainMessage(short actionId, int sourceId, int targetId, short delta) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.delta = delta;
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
		this.targetId = reader.readInt();
		this.delta = reader.readShort();
		if (delta < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on delta = %s, it doesn't respect the following condition : delta < 0", delta));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		writer.writeShort(this.delta);
	}
}