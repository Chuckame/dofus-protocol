package org.michocko.dofus2.protocol.messages.game.basic;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class BasicDateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 177;
	
	private byte day;
	private byte month;
	private short year;
	
	public BasicDateMessage() {
	}
	
	public BasicDateMessage(byte day, byte month, short year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.day = reader.readSByte();
		if (day < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on day = %s, it doesn't respect the following condition : day < 0", day));
		this.month = reader.readSByte();
		if (month < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on month = %s, it doesn't respect the following condition : month < 0", month));
		this.year = reader.readShort();
		if (year < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on year = %s, it doesn't respect the following condition : year < 0", year));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.day);
		writer.writeSByte(this.month);
		writer.writeShort(this.year);
	}
}