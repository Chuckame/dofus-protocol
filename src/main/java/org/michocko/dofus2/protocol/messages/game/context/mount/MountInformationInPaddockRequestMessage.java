package org.michocko.dofus2.protocol.messages.game.context.mount;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MountInformationInPaddockRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5975;
	
	private int mapRideId;
	
	public MountInformationInPaddockRequestMessage() {
	}
	
	public MountInformationInPaddockRequestMessage(int mapRideId) {
		this.mapRideId = mapRideId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mapRideId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.mapRideId);
	}
}