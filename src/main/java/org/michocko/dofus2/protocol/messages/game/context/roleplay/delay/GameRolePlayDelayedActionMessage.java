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
public class GameRolePlayDelayedActionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6153;
	
	private int delayedCharacterId;
	private byte delayTypeId;
	private double delayEndTime;
	
	public GameRolePlayDelayedActionMessage() {
	}
	
	public GameRolePlayDelayedActionMessage(int delayedCharacterId, byte delayTypeId, double delayEndTime) {
		this.delayedCharacterId = delayedCharacterId;
		this.delayTypeId = delayTypeId;
		this.delayEndTime = delayEndTime;
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
		this.delayedCharacterId = reader.readInt();
		this.delayTypeId = reader.readSByte();
		if (delayTypeId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on delayTypeId = %s, it doesn't respect the following condition : delayTypeId < 0", delayTypeId));
		this.delayEndTime = reader.readDouble();
		if (delayEndTime < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on delayEndTime = %s, it doesn't respect the following condition : delayEndTime < 0", delayEndTime));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.delayedCharacterId);
		writer.writeSByte(this.delayTypeId);
		writer.writeDouble(this.delayEndTime);
	}
}