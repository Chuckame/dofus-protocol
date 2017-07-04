package org.michocko.dofus2.protocol.messages.game.alliance;

import org.michocko.dofus2.protocol.types.game.context.roleplay.BasicNamedAllianceInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AllianceInvitedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6397;
	
	private int recruterId;
	private String recruterName;
	private BasicNamedAllianceInformations allianceInfo;
	
	public AllianceInvitedMessage() {
	}
	
	public AllianceInvitedMessage(int recruterId, String recruterName, BasicNamedAllianceInformations allianceInfo) {
		this.recruterId = recruterId;
		this.recruterName = recruterName;
		this.allianceInfo = allianceInfo;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.recruterId = reader.readInt();
		if (recruterId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on recruterId = %s, it doesn't respect the following condition : recruterId < 0", recruterId));
		this.recruterName = reader.readUTF();
		this.allianceInfo = new BasicNamedAllianceInformations();
		this.allianceInfo.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.recruterId);
		writer.writeUTF(this.recruterName);
		this.allianceInfo.serialize(writer);
	}
}