package org.chuckame.dofus2.protocol.messages.web.krosmaster;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class KrosmasterPlayingStatusMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6347;
	
	private boolean playing;
	
	public KrosmasterPlayingStatusMessage() {
	}
	
	public KrosmasterPlayingStatusMessage(boolean playing) {
		this.playing = playing;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.playing = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.playing);
	}
}