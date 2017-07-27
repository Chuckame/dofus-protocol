package org.chuckame.dofus2.protocol.messages.game.basic;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TextInformationMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 780;
	
	private byte msgType;
	private short msgId;
	private Collection<String> parameters;
	
	public TextInformationMessage() {
	}
	
	public TextInformationMessage(byte msgType, short msgId, Collection<String> parameters) {
		this.msgType = msgType;
		this.msgId = msgId;
		this.parameters = parameters;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.msgType = reader.readSByte();
		if (msgType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on msgType = %s, it doesn't respect the following condition : msgType < 0", msgType));
		this.msgId = reader.readShort();
		if (msgId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on msgId = %s, it doesn't respect the following condition : msgId < 0", msgId));
		int length = reader.readUShort();
		this.parameters = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			String entry = reader.readUTF();
			this.parameters.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.msgType);
		writer.writeShort(this.msgId);
		writer.writeUShort(this.parameters.size());
		for (String entry : this.parameters)
		{
			writer.writeUTF(entry);
		}
	}
}