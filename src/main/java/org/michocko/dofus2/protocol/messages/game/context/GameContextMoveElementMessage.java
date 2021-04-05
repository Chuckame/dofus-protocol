package org.michocko.dofus2.protocol.messages.game.context;

import org.michocko.dofus2.protocol.types.game.context.EntityMovementInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameContextMoveElementMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 253;
	
	private EntityMovementInformations movement;
	
	public GameContextMoveElementMessage() {
	}
	
	public GameContextMoveElementMessage(EntityMovementInformations movement) {
		this.movement = movement;
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
		this.movement = new EntityMovementInformations();
		this.movement.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.movement.serialize(writer);
	}
}