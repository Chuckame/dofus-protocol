package org.michocko.dofus2.protocol.messages.game.context.fight;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameFightTurnEndMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 719;
	
	private int id;
	
	public GameFightTurnEndMessage() {
	}
	
	public GameFightTurnEndMessage(int id) {
		this.id = id;
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
		this.id = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
	}
}