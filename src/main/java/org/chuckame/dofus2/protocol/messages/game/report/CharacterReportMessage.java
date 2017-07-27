package org.chuckame.dofus2.protocol.messages.game.report;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CharacterReportMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6079;
	
	private long reportedId;
	private byte reason;
	
	public CharacterReportMessage() {
	}
	
	public CharacterReportMessage(long reportedId, byte reason) {
		this.reportedId = reportedId;
		this.reason = reason;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.reportedId = reader.readUInt();
		if (reportedId < 0 || reportedId > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on reportedId = %s, it doesn't respect the following condition : reportedId < 0 || reportedId > 4.294967295E9", reportedId));
		this.reason = reader.readSByte();
		if (reason < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on reason = %s, it doesn't respect the following condition : reason < 0", reason));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUInt(this.reportedId);
		writer.writeSByte(this.reason);
	}
}