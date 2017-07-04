package org.michocko.dofus2.protocol.messages.game.context.roleplay.document;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class DocumentReadingBeginMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5675;
	
	private short documentId;
	
	public DocumentReadingBeginMessage() {
	}
	
	public DocumentReadingBeginMessage(short documentId) {
		this.documentId = documentId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.documentId = reader.readShort();
		if (documentId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on documentId = %s, it doesn't respect the following condition : documentId < 0", documentId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.documentId);
	}
}