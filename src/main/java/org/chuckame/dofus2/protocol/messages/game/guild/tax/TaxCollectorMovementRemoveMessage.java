package org.chuckame.dofus2.protocol.messages.game.guild.tax;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TaxCollectorMovementRemoveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5915;
	
	private int collectorId;
	
	public TaxCollectorMovementRemoveMessage() {
	}
	
	public TaxCollectorMovementRemoveMessage(int collectorId) {
		this.collectorId = collectorId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.collectorId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.collectorId);
	}
}