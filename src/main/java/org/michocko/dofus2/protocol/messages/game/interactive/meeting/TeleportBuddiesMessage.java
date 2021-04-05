package org.michocko.dofus2.protocol.messages.game.interactive.meeting;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TeleportBuddiesMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6289;
	
	private short dungeonId;
	
	public TeleportBuddiesMessage() {
	}
	
	public TeleportBuddiesMessage(short dungeonId) {
		this.dungeonId = dungeonId;
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
		this.dungeonId = reader.readShort();
		if (dungeonId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dungeonId = %s, it doesn't respect the following condition : dungeonId < 0", dungeonId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.dungeonId);
	}
}