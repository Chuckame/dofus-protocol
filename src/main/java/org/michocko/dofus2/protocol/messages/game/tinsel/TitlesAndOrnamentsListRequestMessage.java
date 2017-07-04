package org.michocko.dofus2.protocol.messages.game.tinsel;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TitlesAndOrnamentsListRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6363;
	
	
	public TitlesAndOrnamentsListRequestMessage() {
	}
	
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
	}
	
	public void serialize(IDataWriter writer) {
	}
}