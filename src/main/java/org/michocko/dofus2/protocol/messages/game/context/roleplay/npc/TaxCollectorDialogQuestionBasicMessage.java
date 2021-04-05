package org.michocko.dofus2.protocol.messages.game.context.roleplay.npc;

import org.michocko.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TaxCollectorDialogQuestionBasicMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5619;
	
	private BasicGuildInformations guildInfo;
	
	public TaxCollectorDialogQuestionBasicMessage() {
	}
	
	public TaxCollectorDialogQuestionBasicMessage(BasicGuildInformations guildInfo) {
		this.guildInfo = guildInfo;
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
		this.guildInfo = new BasicGuildInformations();
		this.guildInfo.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.guildInfo.serialize(writer);
	}
}