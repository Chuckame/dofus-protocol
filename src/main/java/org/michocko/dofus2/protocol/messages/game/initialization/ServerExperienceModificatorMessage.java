package org.michocko.dofus2.protocol.messages.game.initialization;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.experiencePercent = reader.readShort();
		if (experiencePercent < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experiencePercent = %s, it doesn't respect the following condition : experiencePercent < 0", experiencePercent));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.experiencePercent);
	}
}