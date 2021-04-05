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
		this.timeMaxBeforeFightStart = reader.readInt();
		if (timeMaxBeforeFightStart < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on timeMaxBeforeFightStart = %s, it doesn't respect the following condition : timeMaxBeforeFightStart < 0", timeMaxBeforeFightStart));
		this.fightType = reader.readSByte();
		if (fightType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightType = %s, it doesn't respect the following condition : fightType < 0", fightType));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.timeMaxBeforeFightStart);
		writer.writeSByte(this.fightType);
	}
}