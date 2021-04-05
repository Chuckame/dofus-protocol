package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

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
public class ExchangeStartOkJobIndexMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5819;
	
	private Collection<Integer> jobs;
	
	public ExchangeStartOkJobIndexMessage() {
	}
	
	public ExchangeStartOkJobIndexMessage(Collection<Integer> jobs) {
		this.jobs = jobs;
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
		this.jobs = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.jobs.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.jobs.size());
		for (int entry : this.jobs)
		{
			writer.writeInt(entry);
		}
	}
}