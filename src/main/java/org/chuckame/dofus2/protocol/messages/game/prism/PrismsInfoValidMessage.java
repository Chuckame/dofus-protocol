package org.chuckame.dofus2.protocol.messages.game.prism;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.prism.PrismFightersInformation;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PrismsInfoValidMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6451;
	
	private Collection<PrismFightersInformation> fights;
	
	public PrismsInfoValidMessage() {
	}
	
	public PrismsInfoValidMessage(Collection<PrismFightersInformation> fights) {
		this.fights = fights;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.fights = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PrismFightersInformation entry = new PrismFightersInformation();
			entry.deserialize(reader);
			this.fights.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.fights.size());
		for (PrismFightersInformation entry : this.fights)
		{
			entry.serialize(writer);
		}
	}
}