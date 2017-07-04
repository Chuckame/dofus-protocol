package org.michocko.dofus2.protocol.messages.connection;

import org.michocko.dofus2.protocol.messages.connection.IdentificationFailedMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class IdentificationFailedBannedMessage extends IdentificationFailedMessage {
	public static final int MESSAGE_ID = 6174;
	
	private double banEndDate;
	
	public IdentificationFailedBannedMessage() {
	}
	
	public IdentificationFailedBannedMessage(byte reason, double banEndDate) {
		super(reason);
		this.banEndDate = banEndDate;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.banEndDate = reader.readDouble();
		if (banEndDate < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on banEndDate = %s, it doesn't respect the following condition : banEndDate < 0", banEndDate));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeDouble(this.banEndDate);
	}
}