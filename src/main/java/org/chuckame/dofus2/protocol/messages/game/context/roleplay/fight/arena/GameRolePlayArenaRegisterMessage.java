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
public class GameRolePlayArenaRegisterMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6280;
	
	private int battleMode;
	
	public GameRolePlayArenaRegisterMessage() {
	}
	
	public GameRolePlayArenaRegisterMessage(int battleMode) {
		this.battleMode = battleMode;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.battleMode = reader.readInt();
		if (battleMode < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on battleMode = %s, it doesn't respect the following condition : battleMode < 0", battleMode));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.battleMode);
	}
}