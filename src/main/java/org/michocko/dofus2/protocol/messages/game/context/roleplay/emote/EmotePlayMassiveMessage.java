package org.michocko.dofus2.protocol.messages.game.context.roleplay.emote;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.messages.game.context.roleplay.emote.EmotePlayAbstractMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class EmotePlayMassiveMessage extends EmotePlayAbstractMessage {
	public static final int MESSAGE_ID = 5691;
	
	private Collection<Integer> actorIds;
	
	public EmotePlayMassiveMessage() {
	}
	
	public EmotePlayMassiveMessage(short emoteId, double emoteStartTime, Collection<Integer> actorIds) {
		super(emoteId, emoteStartTime);
		this.actorIds = actorIds;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.actorIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.actorIds.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.actorIds.size());
		for (int entry : this.actorIds)
		{
			writer.writeInt(entry);
		}
	}
}