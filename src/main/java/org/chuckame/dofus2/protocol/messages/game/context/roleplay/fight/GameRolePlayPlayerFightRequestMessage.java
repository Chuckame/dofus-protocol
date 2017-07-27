package org.chuckame.dofus2.protocol.messages.game.context.roleplay.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameRolePlayPlayerFightRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5731;
	
	private int targetId;
	private short targetCellId;
	private boolean friendly;
	
	public GameRolePlayPlayerFightRequestMessage() {
	}
	
	public GameRolePlayPlayerFightRequestMessage(int targetId, short targetCellId, boolean friendly) {
		this.targetId = targetId;
		this.targetCellId = targetCellId;
		this.friendly = friendly;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.targetId = reader.readInt();
		if (targetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on targetId = %s, it doesn't respect the following condition : targetId < 0", targetId));
		this.targetCellId = reader.readShort();
		if (targetCellId < -1 || targetCellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on targetCellId = %s, it doesn't respect the following condition : targetCellId < -1 || targetCellId > 559", targetCellId));
		this.friendly = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.targetId);
		writer.writeShort(this.targetCellId);
		writer.writeBoolean(this.friendly);
	}
}