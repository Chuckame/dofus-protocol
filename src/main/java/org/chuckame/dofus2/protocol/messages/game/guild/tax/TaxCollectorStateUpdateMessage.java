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
public class TaxCollectorStateUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6455;
	
	private int uniqueId;
	private byte state;
	
	public TaxCollectorStateUpdateMessage() {
	}
	
	public TaxCollectorStateUpdateMessage(int uniqueId, byte state) {
		this.uniqueId = uniqueId;
		this.state = state;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.uniqueId = reader.readInt();
		this.state = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.uniqueId);
		writer.writeSByte(this.state);
	}
}