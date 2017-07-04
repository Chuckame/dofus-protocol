package org.michocko.dofus2.protocol.messages.game.approach;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AccountLoggingKickedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6029;
	
	private int days;
	private int hours;
	private int minutes;
	
	public AccountLoggingKickedMessage() {
	}
	
	public AccountLoggingKickedMessage(int days, int hours, int minutes) {
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.days = reader.readInt();
		if (days < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on days = %s, it doesn't respect the following condition : days < 0", days));
		this.hours = reader.readInt();
		if (hours < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on hours = %s, it doesn't respect the following condition : hours < 0", hours));
		this.minutes = reader.readInt();
		if (minutes < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on minutes = %s, it doesn't respect the following condition : minutes < 0", minutes));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.days);
		writer.writeInt(this.hours);
		writer.writeInt(this.minutes);
	}
}