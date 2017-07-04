package org.michocko.dofus2.protocol.messages.game.actions.fight;

import org.michocko.dofus2.protocol.messages.game.actions.AbstractGameActionMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class AbstractGameActionFightTargetedAbilityMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 6118;
	
	private int targetId;
	private short destinationCellId;
	private byte critical;
	private boolean silentCast;
	
	public AbstractGameActionFightTargetedAbilityMessage() {
	}
	
	public AbstractGameActionFightTargetedAbilityMessage(short actionId, int sourceId, int targetId, short destinationCellId, byte critical, boolean silentCast) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.destinationCellId = destinationCellId;
		this.critical = critical;
		this.silentCast = silentCast;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.targetId = reader.readInt();
		this.destinationCellId = reader.readShort();
		if (destinationCellId < -1 || destinationCellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on destinationCellId = %s, it doesn't respect the following condition : destinationCellId < -1 || destinationCellId > 559", destinationCellId));
		this.critical = reader.readSByte();
		if (critical < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on critical = %s, it doesn't respect the following condition : critical < 0", critical));
		this.silentCast = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		writer.writeShort(this.destinationCellId);
		writer.writeSByte(this.critical);
		writer.writeBoolean(this.silentCast);
	}
}