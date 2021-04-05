package org.michocko.dofus2.protocol.messages.game.pvp;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SetEnableAVARequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6443;
	
	private boolean enable;
	
	public SetEnableAVARequestMessage() {
	}
	
	public SetEnableAVARequestMessage(boolean enable) {
		this.enable = enable;
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
		this.enable = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.enable);
	}
}