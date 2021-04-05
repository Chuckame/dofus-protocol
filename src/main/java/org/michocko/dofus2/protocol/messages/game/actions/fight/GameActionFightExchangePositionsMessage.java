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
public class GameActionFightExchangePositionsMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5527;
	
	private int targetId;
	private short casterCellId;
	private short targetCellId;
	
	public GameActionFightExchangePositionsMessage() {
	}
	
	public GameActionFightExchangePositionsMessage(short actionId, int sourceId, int targetId, short casterCellId, short targetCellId) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.casterCellId = casterCellId;
		this.targetCellId = targetCellId;
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
		this.casterCellId = reader.readShort();
		if (casterCellId < -1 || casterCellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on casterCellId = %s, it doesn't respect the following condition : casterCellId < -1 || casterCellId > 559", casterCellId));
		this.targetCellId = reader.readShort();
		if (targetCellId < -1 || targetCellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on targetCellId = %s, it doesn't respect the following condition : targetCellId < -1 || targetCellId > 559", targetCellId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		writer.writeShort(this.casterCellId);
		writer.writeShort(this.targetCellId);
	}
}