package org.michocko.dofus2.protocol.messages.game.context.mount;

import org.michocko.dofus2.protocol.types.game.mount.MountClientData;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MountSetMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5968;
	
	private MountClientData mountData;
	
	public MountSetMessage() {
	}
	
	public MountSetMessage(MountClientData mountData) {
		this.mountData = mountData;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mountData = new MountClientData();
		this.mountData.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.mountData.serialize(writer);
	}
}