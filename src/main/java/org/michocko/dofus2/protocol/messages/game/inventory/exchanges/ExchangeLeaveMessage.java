package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.messages.game.dialog.LeaveDialogMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeLeaveMessage extends LeaveDialogMessage {
	public static final int MESSAGE_ID = 5628;
	
	private boolean success;
	
	public ExchangeLeaveMessage() {
	}
	
	public ExchangeLeaveMessage(byte dialogType, boolean success) {
		super(dialogType);
		this.success = success;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.success = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeBoolean(this.success);
	}
}