package org.chuckame.dofus2.protocol.messages.game.interactive.meeting;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TeleportToBuddyCloseMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6303;
	
	private short dungeonId;
	private int buddyId;
	
	public TeleportToBuddyCloseMessage() {
	}
	
	public TeleportToBuddyCloseMessage(short dungeonId, int buddyId) {
		this.dungeonId = dungeonId;
		this.buddyId = buddyId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.dungeonId = reader.readShort();
		if (dungeonId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dungeonId = %s, it doesn't respect the following condition : dungeonId < 0", dungeonId));
		this.buddyId = reader.readInt();
		if (buddyId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on buddyId = %s, it doesn't respect the following condition : buddyId < 0", buddyId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.dungeonId);
		writer.writeInt(this.buddyId);
	}
}