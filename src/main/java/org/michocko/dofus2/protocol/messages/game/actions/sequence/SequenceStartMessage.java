package org.michocko.dofus2.protocol.messages.game.actions.sequence;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.sequenceType = reader.readSByte();
		this.authorId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.sequenceType);
		writer.writeInt(this.authorId);
	}
}