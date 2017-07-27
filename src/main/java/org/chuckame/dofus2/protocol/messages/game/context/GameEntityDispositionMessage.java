package org.chuckame.dofus2.protocol.messages.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.IdentifiedEntityDispositionInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameEntityDispositionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5693;
	
	private IdentifiedEntityDispositionInformations disposition;
	
	public GameEntityDispositionMessage() {
	}
	
	public GameEntityDispositionMessage(IdentifiedEntityDispositionInformations disposition) {
		this.disposition = disposition;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.disposition = new IdentifiedEntityDispositionInformations();
		this.disposition.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.disposition.serialize(writer);
	}
}