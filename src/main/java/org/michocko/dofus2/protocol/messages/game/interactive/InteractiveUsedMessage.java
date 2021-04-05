package org.michocko.dofus2.protocol.messages.game.interactive;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class InteractiveUsedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5745;
	
	private int entityId;
	private int elemId;
	private short skillId;
	private short duration;
	
	public InteractiveUsedMessage() {
	}
	
	public InteractiveUsedMessage(int entityId, int elemId, short skillId, short duration) {
		this.entityId = entityId;
		this.elemId = elemId;
		this.skillId = skillId;
		this.duration = duration;
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
		this.entityId = reader.readInt();
		if (entityId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on entityId = %s, it doesn't respect the following condition : entityId < 0", entityId));
		this.elemId = reader.readInt();
		if (elemId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on elemId = %s, it doesn't respect the following condition : elemId < 0", elemId));
		this.skillId = reader.readShort();
		if (skillId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skillId = %s, it doesn't respect the following condition : skillId < 0", skillId));
		this.duration = reader.readShort();
		if (duration < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on duration = %s, it doesn't respect the following condition : duration < 0", duration));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.entityId);
		writer.writeInt(this.elemId);
		writer.writeShort(this.skillId);
		writer.writeShort(this.duration);
	}
}