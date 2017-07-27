package org.chuckame.dofus2.protocol.messages.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameFightJoinMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 702;
	
	private int timeMaxBeforeFightStart;
	private byte fightType;
	
	public GameFightJoinMessage() {
	}
	
	public GameFightJoinMessage(int timeMaxBeforeFightStart, byte fightType) {
		this.timeMaxBeforeFightStart = timeMaxBeforeFightStart;
		this.fightType = fightType;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.timeMaxBeforeFightStart = reader.readInt();
		if (timeMaxBeforeFightStart < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on timeMaxBeforeFightStart = %s, it doesn't respect the following condition : timeMaxBeforeFightStart < 0", timeMaxBeforeFightStart));
		this.fightType = reader.readSByte();
		if (fightType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightType = %s, it doesn't respect the following condition : fightType < 0", fightType));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.timeMaxBeforeFightStart);
		writer.writeSByte(this.fightType);
	}
}