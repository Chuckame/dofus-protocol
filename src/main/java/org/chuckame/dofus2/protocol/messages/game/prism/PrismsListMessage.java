package org.chuckame.dofus2.protocol.messages.game.prism;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.prism.PrismSubareaEmptyInfo;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PrismsListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6440;
	
	private Collection<PrismSubareaEmptyInfo> prisms;
	
	public PrismsListMessage() {
	}
	
	public PrismsListMessage(Collection<PrismSubareaEmptyInfo> prisms) {
		this.prisms = prisms;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.prisms = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PrismSubareaEmptyInfo entry = ProtocolTypeManager.getInstance().<PrismSubareaEmptyInfo>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.prisms.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.prisms.size());
		for (PrismSubareaEmptyInfo entry : this.prisms)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
	}
}