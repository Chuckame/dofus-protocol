package org.michocko.dofus2.protocol.messages.game.interactive.meeting;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TeleportBuddiesRequestedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6302;
	
	private short dungeonId;
	private int inviterId;
	private Collection<Integer> invalidBuddiesIds;
	
	public TeleportBuddiesRequestedMessage() {
	}
	
	public TeleportBuddiesRequestedMessage(short dungeonId, int inviterId, Collection<Integer> invalidBuddiesIds) {
		this.dungeonId = dungeonId;
		this.inviterId = inviterId;
		this.invalidBuddiesIds = invalidBuddiesIds;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.dungeonId = reader.readShort();
		if (dungeonId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dungeonId = %s, it doesn't respect the following condition : dungeonId < 0", dungeonId));
		this.inviterId = reader.readInt();
		if (inviterId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on inviterId = %s, it doesn't respect the following condition : inviterId < 0", inviterId));
		int length = reader.readUShort();
		this.invalidBuddiesIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.invalidBuddiesIds.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.dungeonId);
		writer.writeInt(this.inviterId);
		writer.writeUShort(this.invalidBuddiesIds.size());
		for (int entry : this.invalidBuddiesIds)
		{
			writer.writeInt(entry);
		}
	}
}