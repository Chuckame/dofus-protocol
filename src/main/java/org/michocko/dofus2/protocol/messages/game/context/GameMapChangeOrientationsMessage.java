package org.michocko.dofus2.protocol.messages.game.context;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.ActorOrientation;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameMapChangeOrientationsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6155;
	
	private Collection<ActorOrientation> orientations;
	
	public GameMapChangeOrientationsMessage() {
	}
	
	public GameMapChangeOrientationsMessage(Collection<ActorOrientation> orientations) {
		this.orientations = orientations;
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
		int length = reader.readUShort();
		this.orientations = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ActorOrientation entry = new ActorOrientation();
			entry.deserialize(reader);
			this.orientations.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.orientations.size());
		for (ActorOrientation entry : this.orientations)
		{
			entry.serialize(writer);
		}
	}
}