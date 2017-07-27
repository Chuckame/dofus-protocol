package org.chuckame.dofus2.protocol.messages.game.context.mount;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mapRideId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.mapRideId);
	}
}