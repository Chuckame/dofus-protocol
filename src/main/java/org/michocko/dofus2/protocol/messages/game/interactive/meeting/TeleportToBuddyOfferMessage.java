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
public class TeleportToBuddyOfferMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6287;
	
	private short dungeonId;
	private int buddyId;
	private int timeLeft;
	
	public TeleportToBuddyOfferMessage() {
	}
	
	public TeleportToBuddyOfferMessage(short dungeonId, int buddyId, int timeLeft) {
		this.dungeonId = dungeonId;
		this.buddyId = buddyId;
		this.timeLeft = timeLeft;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.dungeonId = reader.readShort();
		if (dungeonId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dungeonId = %s, it doesn't respect the following condition : dungeonId < 0", dungeonId));
		this.buddyId = reader.readInt();
		if (buddyId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on buddyId = %s, it doesn't respect the following condition : buddyId < 0", buddyId));
		this.timeLeft = reader.readInt();
		if (timeLeft < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on timeLeft = %s, it doesn't respect the following condition : timeLeft < 0", timeLeft));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.dungeonId);
		writer.writeInt(this.buddyId);
		writer.writeInt(this.timeLeft);
	}
}