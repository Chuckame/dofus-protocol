package org.chuckame.dofus2.protocol.messages.game.script;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CinematicMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6053;
	
	private short cinematicId;
	
	public CinematicMessage() {
	}
	
	public CinematicMessage(short cinematicId) {
		this.cinematicId = cinematicId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.cinematicId = reader.readShort();
		if (cinematicId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on cinematicId = %s, it doesn't respect the following condition : cinematicId < 0", cinematicId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.cinematicId);
	}
}