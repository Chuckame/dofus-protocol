package org.michocko.dofus2.protocol.messages.game.context.roleplay.delay;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameRolePlayDelayedActionFinishedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6150;
	
	private int delayedCharacterId;
	private byte delayTypeId;
	
	public GameRolePlayDelayedActionFinishedMessage() {
	}
	
	public GameRolePlayDelayedActionFinishedMessage(int delayedCharacterId, byte delayTypeId) {
		this.delayedCharacterId = delayedCharacterId;
		this.delayTypeId = delayTypeId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.delayedCharacterId = reader.readInt();
		this.delayTypeId = reader.readSByte();
		if (delayTypeId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on delayTypeId = %s, it doesn't respect the following condition : delayTypeId < 0", delayTypeId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.delayedCharacterId);
		writer.writeSByte(this.delayTypeId);
	}
}