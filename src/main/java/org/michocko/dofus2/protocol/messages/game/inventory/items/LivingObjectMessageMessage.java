package org.michocko.dofus2.protocol.messages.game.inventory.items;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class LivingObjectMessageMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6065;
	
	private short msgId;
	private long timeStamp;
	private String owner;
	private long objectGenericId;
	
	public LivingObjectMessageMessage() {
	}
	
	public LivingObjectMessageMessage(short msgId, long timeStamp, String owner, long objectGenericId) {
		this.msgId = msgId;
		this.timeStamp = timeStamp;
		this.owner = owner;
		this.objectGenericId = objectGenericId;
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
		this.msgId = reader.readShort();
		if (msgId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on msgId = %s, it doesn't respect the following condition : msgId < 0", msgId));
		this.timeStamp = reader.readUInt();
		if (timeStamp < 0 || timeStamp > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on timeStamp = %s, it doesn't respect the following condition : timeStamp < 0 || timeStamp > 4.294967295E9", timeStamp));
		this.owner = reader.readUTF();
		this.objectGenericId = reader.readUInt();
		if (objectGenericId < 0 || objectGenericId > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on objectGenericId = %s, it doesn't respect the following condition : objectGenericId < 0 || objectGenericId > 4.294967295E9", objectGenericId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.msgId);
		writer.writeUInt(this.timeStamp);
		writer.writeUTF(this.owner);
		writer.writeUInt(this.objectGenericId);
	}
}