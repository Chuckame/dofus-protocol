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
public class TeleportToBuddyAnswerMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6293;
	
	private short dungeonId;
	private int buddyId;
	private boolean accept;
	
	public TeleportToBuddyAnswerMessage() {
	}
	
	public TeleportToBuddyAnswerMessage(short dungeonId, int buddyId, boolean accept) {
		this.dungeonId = dungeonId;
		this.buddyId = buddyId;
		this.accept = accept;
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
		this.buddyId = reader.readInt();
		if (buddyId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on buddyId = %s, it doesn't respect the following condition : buddyId < 0", buddyId));
		this.accept = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.dungeonId);
		writer.writeInt(this.buddyId);
		writer.writeBoolean(this.accept);
	}
}