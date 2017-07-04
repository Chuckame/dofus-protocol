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
public class GameActionFightPointsVariationMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 1030;
	
	private int targetId;
	private short delta;
	
	public GameActionFightPointsVariationMessage() {
	}
	
	public GameActionFightPointsVariationMessage(short actionId, int sourceId, int targetId, short delta) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.delta = delta;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.targetId = reader.readInt();
		this.delta = reader.readShort();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		writer.writeShort(this.delta);
	}
}