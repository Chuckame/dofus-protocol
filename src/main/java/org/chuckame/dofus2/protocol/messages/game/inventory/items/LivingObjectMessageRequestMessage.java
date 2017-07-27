package org.chuckame.dofus2.protocol.messages.game.inventory.items;

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
public class LivingObjectMessageRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6066;
	
	private short msgId;
	private Collection<String> parameters;
	private long livingObject;
	
	public LivingObjectMessageRequestMessage() {
	}
	
	public LivingObjectMessageRequestMessage(short msgId, Collection<String> parameters, long livingObject) {
		this.msgId = msgId;
		this.parameters = parameters;
		this.livingObject = livingObject;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
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
		this.livingObject = reader.readUInt();
		if (livingObject < 0 || livingObject > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on livingObject = %s, it doesn't respect the following condition : livingObject < 0 || livingObject > 4.294967295E9", livingObject));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.msgId);
		writer.writeUShort(this.parameters.size());
		for (String entry : this.parameters)
		{
			writer.writeUTF(entry);
		}
		writer.writeUInt(this.livingObject);
	}
}