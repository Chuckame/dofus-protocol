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
public class GameActionFightLifePointsLostMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 6312;
	
	private int targetId;
	private short loss;
	private short permanentDamages;
	
	public GameActionFightLifePointsLostMessage() {
	}
	
	public GameActionFightLifePointsLostMessage(short actionId, int sourceId, int targetId, short loss, short permanentDamages) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.loss = loss;
		this.permanentDamages = permanentDamages;
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
		this.loss = reader.readShort();
		if (loss < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on loss = %s, it doesn't respect the following condition : loss < 0", loss));
		this.permanentDamages = reader.readShort();
		if (permanentDamages < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on permanentDamages = %s, it doesn't respect the following condition : permanentDamages < 0", permanentDamages));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		writer.writeShort(this.loss);
		writer.writeShort(this.permanentDamages);
	}
}