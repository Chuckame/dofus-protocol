package org.chuckame.dofus2.protocol.messages.game.modificator;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AreaFightModificatorUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6493;
	
	private int spellPairId;
	
	public AreaFightModificatorUpdateMessage() {
	}
	
	public AreaFightModificatorUpdateMessage(int spellPairId) {
		this.spellPairId = spellPairId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.spellPairId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.spellPairId);
	}
}