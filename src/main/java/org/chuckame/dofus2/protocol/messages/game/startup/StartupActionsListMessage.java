package org.chuckame.dofus2.protocol.messages.game.startup;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.startup.StartupActionAddObject;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class StartupActionsListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1301;
	
	private Collection<StartupActionAddObject> actions;
	
	public StartupActionsListMessage() {
	}
	
	public StartupActionsListMessage(Collection<StartupActionAddObject> actions) {
		this.actions = actions;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.actions = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			StartupActionAddObject entry = new StartupActionAddObject();
			entry.deserialize(reader);
			this.actions.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.actions.size());
		for (StartupActionAddObject entry : this.actions)
		{
			entry.serialize(writer);
		}
	}
}