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
public class GameActionFightVanishMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 6217;
	
	private int targetId;
	
	public GameActionFightVanishMessage() {
	}
	
	public GameActionFightVanishMessage(short actionId, int sourceId, int targetId) {
		super(actionId, sourceId);
		this.targetId = targetId;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.targetId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
	}
}