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
public class GameFightStartingMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 700;
	
	private byte fightType;
	private int attackerId;
	private int defenderId;
	
	public GameFightStartingMessage() {
	}
	
	public GameFightStartingMessage(byte fightType, int attackerId, int defenderId) {
		this.fightType = fightType;
		this.attackerId = attackerId;
		this.defenderId = defenderId;
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
		this.fightType = reader.readSByte();
		if (fightType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightType = %s, it doesn't respect the following condition : fightType < 0", fightType));
		this.attackerId = reader.readInt();
		this.defenderId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.fightType);
		writer.writeInt(this.attackerId);
		writer.writeInt(this.defenderId);
	}
}