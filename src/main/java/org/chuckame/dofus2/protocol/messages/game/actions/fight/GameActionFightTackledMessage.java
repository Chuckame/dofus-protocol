package org.chuckame.dofus2.protocol.messages.game.actions.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.actions.AbstractGameActionMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightTackledMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 1004;
	
	private Collection<Integer> tacklersIds;
	
	public GameActionFightTackledMessage() {
	}
	
	public GameActionFightTackledMessage(short actionId, int sourceId, Collection<Integer> tacklersIds) {
		super(actionId, sourceId);
		this.tacklersIds = tacklersIds;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.tacklersIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.tacklersIds.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.tacklersIds.size());
		for (int entry : this.tacklersIds)
		{
			writer.writeInt(entry);
		}
	}
}