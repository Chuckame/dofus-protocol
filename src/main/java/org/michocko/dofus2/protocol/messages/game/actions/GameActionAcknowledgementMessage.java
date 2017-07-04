package org.michocko.dofus2.protocol.messages.game.actions;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameActionAcknowledgementMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 957;
	
	private boolean valid;
	private byte actionId;
	
	public GameActionAcknowledgementMessage() {
	}
	
	public GameActionAcknowledgementMessage(boolean valid, byte actionId) {
		this.valid = valid;
		this.actionId = actionId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.valid = reader.readBoolean();
		this.actionId = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.valid);
		writer.writeSByte(this.actionId);
	}
}