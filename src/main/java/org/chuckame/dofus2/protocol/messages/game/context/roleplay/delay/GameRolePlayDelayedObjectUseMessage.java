package org.chuckame.dofus2.protocol.messages.game.context.roleplay.delay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.delay.GameRolePlayDelayedActionMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameRolePlayDelayedObjectUseMessage extends GameRolePlayDelayedActionMessage {
	public static final int MESSAGE_ID = 6425;
	
	private short objectGID;
	
	public GameRolePlayDelayedObjectUseMessage() {
	}
	
	public GameRolePlayDelayedObjectUseMessage(int delayedCharacterId, byte delayTypeId, double delayEndTime, short objectGID) {
		super(delayedCharacterId, delayTypeId, delayEndTime);
		this.objectGID = objectGID;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.objectGID = reader.readShort();
		if (objectGID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectGID = %s, it doesn't respect the following condition : objectGID < 0", objectGID));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.objectGID);
	}
}