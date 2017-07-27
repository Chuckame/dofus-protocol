package org.chuckame.dofus2.protocol.messages.game.context;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.GameContextRemoveMultipleElementsMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameContextRemoveMultipleElementsWithEventsMessage extends GameContextRemoveMultipleElementsMessage {
	public static final int MESSAGE_ID = 6416;
	
	private Collection<Byte> elementEventIds;
	
	public GameContextRemoveMultipleElementsWithEventsMessage() {
	}
	
	public GameContextRemoveMultipleElementsWithEventsMessage(Collection<Integer> id, Collection<Byte> elementEventIds) {
		super(id);
		this.elementEventIds = elementEventIds;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.elementEventIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			byte entry = reader.readSByte();
			this.elementEventIds.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.elementEventIds.size());
		for (byte entry : this.elementEventIds)
		{
			writer.writeSByte(entry);
		}
	}
}