package org.michocko.dofus2.protocol.messages.game.context.roleplay.fight;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.targetId = reader.readInt();
		if (targetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on targetId = %s, it doesn't respect the following condition : targetId < 0", targetId));
		this.targetCellId = reader.readShort();
		if (targetCellId < -1 || targetCellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on targetCellId = %s, it doesn't respect the following condition : targetCellId < -1 || targetCellId > 559", targetCellId));
		this.friendly = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.targetId);
		writer.writeShort(this.targetCellId);
		writer.writeBoolean(this.friendly);
	}
}