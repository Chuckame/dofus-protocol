package org.chuckame.dofus2.protocol.messages.game.pvp;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SetEnablePVPRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1810;
	
	private boolean enable;
	
	public SetEnablePVPRequestMessage() {
	}
	
	public SetEnablePVPRequestMessage(boolean enable) {
		this.enable = enable;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.enable = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.enable);
	}
}