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
public class GameFightOptionStateUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5927;
	
	private short fightId;
	private byte teamId;
	private byte option;
	private boolean state;
	
	public GameFightOptionStateUpdateMessage() {
	}
	
	public GameFightOptionStateUpdateMessage(short fightId, byte teamId, byte option, boolean state) {
		this.fightId = fightId;
		this.teamId = teamId;
		this.option = option;
		this.state = state;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightId = reader.readShort();
		if (fightId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightId = %s, it doesn't respect the following condition : fightId < 0", fightId));
		this.teamId = reader.readSByte();
		if (teamId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on teamId = %s, it doesn't respect the following condition : teamId < 0", teamId));
		this.option = reader.readSByte();
		if (option < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on option = %s, it doesn't respect the following condition : option < 0", option));
		this.state = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.fightId);
		writer.writeSByte(this.teamId);
		writer.writeSByte(this.option);
		writer.writeBoolean(this.state);
	}
}