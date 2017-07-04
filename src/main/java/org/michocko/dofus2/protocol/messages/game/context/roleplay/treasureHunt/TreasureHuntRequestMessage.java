package org.michocko.dofus2.protocol.messages.game.context.roleplay.treasureHunt;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TreasureHuntRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6488;
	
	private short questLevel;
	private byte questType;
	
	public TreasureHuntRequestMessage() {
	}
	
	public TreasureHuntRequestMessage(short questLevel, byte questType) {
		this.questLevel = questLevel;
		this.questType = questType;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.questLevel = reader.readByte();
		if (questLevel < 1 || questLevel > 200)
			throw new IllegalArgumentException(String.format("Forbidden value on questLevel = %s, it doesn't respect the following condition : questLevel < 1 || questLevel > 200", questLevel));
		this.questType = reader.readSByte();
		if (questType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on questType = %s, it doesn't respect the following condition : questType < 0", questType));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeByte(this.questLevel);
		writer.writeSByte(this.questType);
	}
}