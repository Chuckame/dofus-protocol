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
public class AllianceModificationEmblemValidMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6447;
	
	private GuildEmblem Alliancemblem;
	
	public AllianceModificationEmblemValidMessage() {
	}
	
	public AllianceModificationEmblemValidMessage(GuildEmblem Alliancemblem) {
		this.Alliancemblem = Alliancemblem;
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
		this.Alliancemblem = new GuildEmblem();
		this.Alliancemblem.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.Alliancemblem.serialize(writer);
	}
}