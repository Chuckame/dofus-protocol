package org.chuckame.dofus2.protocol.messages.game.actions.sequence;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SequenceStartMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 955;
	
	private byte sequenceType;
	private int authorId;
	
	public SequenceStartMessage() {
	}
	
	public SequenceStartMessage(byte sequenceType, int authorId) {
		this.sequenceType = sequenceType;
		this.authorId = authorId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.sequenceType = reader.readSByte();
		this.authorId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.sequenceType);
		writer.writeInt(this.authorId);
	}
}