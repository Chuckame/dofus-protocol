package org.michocko.dofus2.protocol.messages.game.almanach;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AlmanachCalendarDateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6341;
	
	private int date;
	
	public AlmanachCalendarDateMessage() {
	}
	
	public AlmanachCalendarDateMessage(int date) {
		this.date = date;
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
		this.date = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.date);
	}
}