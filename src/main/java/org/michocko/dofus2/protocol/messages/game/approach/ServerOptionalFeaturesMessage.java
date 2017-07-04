package org.michocko.dofus2.protocol.messages.game.approach;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ServerOptionalFeaturesMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6305;
	
	private Collection<Short> features;
	
	public ServerOptionalFeaturesMessage() {
	}
	
	public ServerOptionalFeaturesMessage(Collection<Short> features) {
		this.features = features;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.features = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.features.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.features.size());
		for (short entry : this.features)
		{
			writer.writeShort(entry);
		}
	}
}