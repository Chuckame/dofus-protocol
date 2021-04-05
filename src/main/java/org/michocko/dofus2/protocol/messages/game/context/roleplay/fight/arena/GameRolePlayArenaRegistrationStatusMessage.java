package org.michocko.dofus2.protocol.messages.game.context.roleplay.fight.arena;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.registered = reader.readBoolean();
		this.step = reader.readSByte();
		if (step < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on step = %s, it doesn't respect the following condition : step < 0", step));
		this.battleMode = reader.readInt();
		if (battleMode < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on battleMode = %s, it doesn't respect the following condition : battleMode < 0", battleMode));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.registered);
		writer.writeSByte(this.step);
		writer.writeInt(this.battleMode);
	}
}