package org.chuckame.dofus2.protocol.messages.game.actions.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameActionFightCastRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1005;
	
	private short spellId;
	private short cellId;
	
	public GameActionFightCastRequestMessage() {
	}
	
	public GameActionFightCastRequestMessage(short spellId, short cellId) {
		this.spellId = spellId;
		this.cellId = cellId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.spellId = reader.readShort();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
		this.cellId = reader.readShort();
		if (cellId < -1 || cellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on cellId = %s, it doesn't respect the following condition : cellId < -1 || cellId > 559", cellId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.spellId);
		writer.writeShort(this.cellId);
	}
}