package org.michocko.dofus2.protocol.messages.game.guild;

import org.michocko.dofus2.protocol.types.game.paddock.PaddockContentInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildPaddockBoughtMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5952;
	
	private PaddockContentInformations paddockInfo;
	
	public GuildPaddockBoughtMessage() {
	}
	
	public GuildPaddockBoughtMessage(PaddockContentInformations paddockInfo) {
		this.paddockInfo = paddockInfo;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.paddockInfo = new PaddockContentInformations();
		this.paddockInfo.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.paddockInfo.serialize(writer);
	}
}