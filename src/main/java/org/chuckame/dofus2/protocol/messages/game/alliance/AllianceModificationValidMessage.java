package org.chuckame.dofus2.protocol.messages.game.alliance;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.guild.GuildEmblem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AllianceModificationValidMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6450;
	
	private String allianceName;
	private String allianceTag;
	private GuildEmblem Alliancemblem;
	
	public AllianceModificationValidMessage() {
	}
	
	public AllianceModificationValidMessage(String allianceName, String allianceTag, GuildEmblem Alliancemblem) {
		this.allianceName = allianceName;
		this.allianceTag = allianceTag;
		this.Alliancemblem = Alliancemblem;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.allianceName = reader.readUTF();
		this.allianceTag = reader.readUTF();
		this.Alliancemblem = new GuildEmblem();
		this.Alliancemblem.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.allianceName);
		writer.writeUTF(this.allianceTag);
		this.Alliancemblem.serialize(writer);
	}
}