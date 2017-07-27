package org.chuckame.dofus2.protocol.messages.game.guild;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ChallengeFightJoinRefusedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5908;
	
	private int playerId;
	private byte reason;
	
	public ChallengeFightJoinRefusedMessage() {
	}
	
	public ChallengeFightJoinRefusedMessage(int playerId, byte reason) {
		this.playerId = playerId;
		this.reason = reason;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		this.reason = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.playerId);
		writer.writeSByte(this.reason);
	}
}