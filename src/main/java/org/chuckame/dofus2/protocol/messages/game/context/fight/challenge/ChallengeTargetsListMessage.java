package org.chuckame.dofus2.protocol.messages.game.context.fight.challenge;

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
public class ChallengeTargetsListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5613;
	
	private Collection<Integer> targetIds;
	private Collection<Short> targetCells;
	
	public ChallengeTargetsListMessage() {
	}
	
	public ChallengeTargetsListMessage(Collection<Integer> targetIds, Collection<Short> targetCells) {
		this.targetIds = targetIds;
		this.targetCells = targetCells;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.targetIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.targetIds.add(entry);
		}
		length = reader.readUShort();
		this.targetCells = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.targetCells.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.targetIds.size());
		for (int entry : this.targetIds)
		{
			writer.writeInt(entry);
		}
		writer.writeUShort(this.targetCells.size());
		for (short entry : this.targetCells)
		{
			writer.writeShort(entry);
		}
	}
}