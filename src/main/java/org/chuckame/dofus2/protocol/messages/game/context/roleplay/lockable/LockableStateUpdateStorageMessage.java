package org.chuckame.dofus2.protocol.messages.game.context.roleplay.lockable;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.lockable.LockableStateUpdateAbstractMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class LockableStateUpdateStorageMessage extends LockableStateUpdateAbstractMessage {
	public static final int MESSAGE_ID = 5669;
	
	private int mapId;
	private int elementId;
	
	public LockableStateUpdateStorageMessage() {
	}
	
	public LockableStateUpdateStorageMessage(boolean locked, int mapId, int elementId) {
		super(locked);
		this.mapId = mapId;
		this.elementId = elementId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.mapId = reader.readInt();
		this.elementId = reader.readInt();
		if (elementId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on elementId = %s, it doesn't respect the following condition : elementId < 0", elementId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.mapId);
		writer.writeInt(this.elementId);
	}
}