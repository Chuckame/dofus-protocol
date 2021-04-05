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
public class GameActionFightCastOnTargetRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6330;
	
	private short spellId;
	private int targetId;
	
	public GameActionFightCastOnTargetRequestMessage() {
	}
	
	public GameActionFightCastOnTargetRequestMessage(short spellId, int targetId) {
		this.spellId = spellId;
		this.targetId = targetId;
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
		this.targetId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.spellId);
		writer.writeInt(this.targetId);
	}
}