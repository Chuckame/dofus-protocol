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
public class GameFightJoinRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 701;
	
	private int fighterId;
	private int fightId;
	
	public GameFightJoinRequestMessage() {
	}
	
	public GameFightJoinRequestMessage(int fighterId, int fightId) {
		this.fighterId = fighterId;
		this.fightId = fightId;
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
		this.fighterId = reader.readInt();
		this.fightId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.fighterId);
		writer.writeInt(this.fightId);
	}
}