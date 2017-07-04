package org.michocko.dofus2.protocol.messages.game.context.roleplay.visual;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameRolePlaySpellAnimMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6114;
	
	private int casterId;
	private short targetCellId;
	private short spellId;
	private byte spellLevel;
	
	public GameRolePlaySpellAnimMessage() {
	}
	
	public GameRolePlaySpellAnimMessage(int casterId, short targetCellId, short spellId, byte spellLevel) {
		this.casterId = casterId;
		this.targetCellId = targetCellId;
		this.spellId = spellId;
		this.spellLevel = spellLevel;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.casterId = reader.readInt();
		this.targetCellId = reader.readShort();
		if (targetCellId < 0 || targetCellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on targetCellId = %s, it doesn't respect the following condition : targetCellId < 0 || targetCellId > 559", targetCellId));
		this.spellId = reader.readShort();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
		this.spellLevel = reader.readSByte();
		if (spellLevel < 1 || spellLevel > 6)
			throw new IllegalArgumentException(String.format("Forbidden value on spellLevel = %s, it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6", spellLevel));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.casterId);
		writer.writeShort(this.targetCellId);
		writer.writeShort(this.spellId);
		writer.writeSByte(this.spellLevel);
	}
}