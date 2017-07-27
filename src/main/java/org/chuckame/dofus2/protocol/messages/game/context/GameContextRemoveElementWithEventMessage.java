package org.chuckame.dofus2.protocol.messages.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.GameContextRemoveElementMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameContextRemoveElementWithEventMessage extends GameContextRemoveElementMessage {
	public static final int MESSAGE_ID = 6412;
	
	private byte elementEventId;
	
	public GameContextRemoveElementWithEventMessage() {
	}
	
	public GameContextRemoveElementWithEventMessage(int id, byte elementEventId) {
		super(id);
		this.elementEventId = elementEventId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.elementEventId = reader.readSByte();
		if (elementEventId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on elementEventId = %s, it doesn't respect the following condition : elementEventId < 0", elementEventId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.elementEventId);
	}
}