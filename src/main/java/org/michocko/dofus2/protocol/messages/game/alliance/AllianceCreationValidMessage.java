package org.michocko.dofus2.protocol.messages.game.alliance;

import org.michocko.dofus2.protocol.types.game.guild.GuildEmblem;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AllianceCreationValidMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6393;
	
	private String allianceName;
	private String allianceTag;
	private GuildEmblem allianceEmblem;
	
	public AllianceCreationValidMessage() {
	}
	
	public AllianceCreationValidMessage(String allianceName, String allianceTag, GuildEmblem allianceEmblem) {
		this.allianceName = allianceName;
		this.allianceTag = allianceTag;
		this.allianceEmblem = allianceEmblem;
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
		this.allianceName = reader.readUTF();
		this.allianceTag = reader.readUTF();
		this.allianceEmblem = new GuildEmblem();
		this.allianceEmblem.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.allianceName);
		writer.writeUTF(this.allianceTag);
		this.allianceEmblem.serialize(writer);
	}
}