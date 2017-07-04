package org.michocko.dofus2.protocol.messages.game.prism;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PrismFightSwapRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5901;
	
	private short subAreaId;
	private int targetId;
	
	public PrismFightSwapRequestMessage() {
	}
	
	public PrismFightSwapRequestMessage(short subAreaId, int targetId) {
		this.subAreaId = subAreaId;
		this.targetId = targetId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.targetId = reader.readInt();
		if (targetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on targetId = %s, it doesn't respect the following condition : targetId < 0", targetId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.subAreaId);
		writer.writeInt(this.targetId);
	}
}