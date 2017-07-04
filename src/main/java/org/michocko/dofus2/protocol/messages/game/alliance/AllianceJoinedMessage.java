package org.michocko.dofus2.protocol.messages.game.alliance;

import org.michocko.dofus2.protocol.types.game.context.roleplay.AllianceInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AllianceJoinedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6402;
	
	private AllianceInformations allianceInfo;
	private boolean enabled;
	
	public AllianceJoinedMessage() {
	}
	
	public AllianceJoinedMessage(AllianceInformations allianceInfo, boolean enabled) {
		this.allianceInfo = allianceInfo;
		this.enabled = enabled;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.allianceInfo = new AllianceInformations();
		this.allianceInfo.deserialize(reader);
		this.enabled = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		this.allianceInfo.serialize(writer);
		writer.writeBoolean(this.enabled);
	}
}