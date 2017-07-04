package org.michocko.dofus2.protocol.messages.game.guild.tax;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TaxCollectorErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5634;
	
	private byte reason;
	
	public TaxCollectorErrorMessage() {
	}
	
	public TaxCollectorErrorMessage(byte reason) {
		this.reason = reason;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.reason = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.reason);
	}
}