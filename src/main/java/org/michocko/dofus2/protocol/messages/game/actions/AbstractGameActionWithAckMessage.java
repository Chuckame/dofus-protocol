package org.michocko.dofus2.protocol.messages.game.actions;

import org.michocko.dofus2.protocol.messages.game.actions.AbstractGameActionMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class AbstractGameActionWithAckMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 1001;
	
	private short waitAckId;
	
	public AbstractGameActionWithAckMessage() {
	}
	
	public AbstractGameActionWithAckMessage(short actionId, int sourceId, short waitAckId) {
		super(actionId, sourceId);
		this.waitAckId = waitAckId;
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
		this.waitAckId = reader.readShort();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.waitAckId);
	}
}