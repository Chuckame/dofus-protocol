package org.chuckame.dofus2.protocol.messages.game.initialization;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ServerExperienceModificatorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6237;
	
	private short experiencePercent;
	
	public ServerExperienceModificatorMessage() {
	}
	
	public ServerExperienceModificatorMessage(short experiencePercent) {
		this.experiencePercent = experiencePercent;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.experiencePercent = reader.readShort();
		if (experiencePercent < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experiencePercent = %s, it doesn't respect the following condition : experiencePercent < 0", experiencePercent));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.experiencePercent);
	}
}