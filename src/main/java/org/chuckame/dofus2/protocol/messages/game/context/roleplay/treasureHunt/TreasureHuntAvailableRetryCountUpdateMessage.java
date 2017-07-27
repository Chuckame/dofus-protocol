package org.chuckame.dofus2.protocol.messages.game.context.roleplay.treasureHunt;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TreasureHuntAvailableRetryCountUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6491;
	
	private byte questType;
	private int availableRetryCount;
	
	public TreasureHuntAvailableRetryCountUpdateMessage() {
	}
	
	public TreasureHuntAvailableRetryCountUpdateMessage(byte questType, int availableRetryCount) {
		this.questType = questType;
		this.availableRetryCount = availableRetryCount;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.questType = reader.readSByte();
		if (questType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on questType = %s, it doesn't respect the following condition : questType < 0", questType));
		this.availableRetryCount = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.questType);
		writer.writeInt(this.availableRetryCount);
	}
}