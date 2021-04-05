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
		this.actionId = reader.readShort();
		if (actionId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on actionId = %s, it doesn't respect the following condition : actionId < 0", actionId));
		this.authorId = reader.readInt();
		this.sequenceType = reader.readSByte();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.actionId);
		writer.writeInt(this.authorId);
		writer.writeSByte(this.sequenceType);
	}
}