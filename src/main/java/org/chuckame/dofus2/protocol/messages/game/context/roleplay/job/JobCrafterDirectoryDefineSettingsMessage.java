package org.chuckame.dofus2.protocol.messages.game.context.roleplay.job;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.job.JobCrafterDirectorySettings;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class JobCrafterDirectoryDefineSettingsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5649;
	
	private JobCrafterDirectorySettings settings;
	
	public JobCrafterDirectoryDefineSettingsMessage() {
	}
	
	public JobCrafterDirectoryDefineSettingsMessage(JobCrafterDirectorySettings settings) {
		this.settings = settings;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.settings = new JobCrafterDirectorySettings();
		this.settings.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.settings.serialize(writer);
	}
}