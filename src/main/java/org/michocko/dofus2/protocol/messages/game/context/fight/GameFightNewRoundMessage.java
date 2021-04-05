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
public class GameFightNewRoundMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6239;
	
	private int roundNumber;
	
	public GameFightNewRoundMessage() {
	}
	
	public GameFightNewRoundMessage(int roundNumber) {
		this.roundNumber = roundNumber;
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
		this.roundNumber = reader.readInt();
		if (roundNumber < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on roundNumber = %s, it doesn't respect the following condition : roundNumber < 0", roundNumber));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.roundNumber);
	}
}