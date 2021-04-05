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
public class GameActionFightInvisibilityMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5821;
	
	private int targetId;
	private byte state;
	
	public GameActionFightInvisibilityMessage() {
	}
	
	public GameActionFightInvisibilityMessage(short actionId, int sourceId, int targetId, byte state) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.state = state;
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
		this.state = reader.readSByte();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		writer.writeSByte(this.state);
	}
}