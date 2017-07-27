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
public class SequenceEndMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 956;
	
	private short actionId;
	private int authorId;
	private byte sequenceType;
	
	public SequenceEndMessage() {
	}
	
	public SequenceEndMessage(short actionId, int authorId, byte sequenceType) {
		this.actionId = actionId;
		this.authorId = authorId;
		this.sequenceType = sequenceType;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.actionId = reader.readShort();
		if (actionId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on actionId = %s, it doesn't respect the following condition : actionId < 0", actionId));
		this.authorId = reader.readInt();
		this.sequenceType = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.actionId);
		writer.writeInt(this.authorId);
		writer.writeSByte(this.sequenceType);
	}
}