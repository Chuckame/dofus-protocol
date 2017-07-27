package org.chuckame.dofus2.protocol.messages.game.context.roleplay.fight.arena;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameRolePlayArenaRegistrationStatusMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6284;
	
	private boolean registered;
	private byte step;
	private int battleMode;
	
	public GameRolePlayArenaRegistrationStatusMessage() {
	}
	
	public GameRolePlayArenaRegistrationStatusMessage(boolean registered, byte step, int battleMode) {
		this.registered = registered;
		this.step = step;
		this.battleMode = battleMode;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.registered = reader.readBoolean();
		this.step = reader.readSByte();
		if (step < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on step = %s, it doesn't respect the following condition : step < 0", step));
		this.battleMode = reader.readInt();
		if (battleMode < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on battleMode = %s, it doesn't respect the following condition : battleMode < 0", battleMode));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.registered);
		writer.writeSByte(this.step);
		writer.writeInt(this.battleMode);
	}
}