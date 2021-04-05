package org.michocko.dofus2.protocol.messages.game.actions.fight;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.spellId = reader.readShort();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
		this.cellId = reader.readShort();
		if (cellId < -1 || cellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on cellId = %s, it doesn't respect the following condition : cellId < -1 || cellId > 559", cellId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.spellId);
		writer.writeShort(this.cellId);
	}
}