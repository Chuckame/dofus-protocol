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
public class TreasureHuntDigRequestAnswerMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6484;
	
	private byte questType;
	private byte result;
	
	public TreasureHuntDigRequestAnswerMessage() {
	}
	
	public TreasureHuntDigRequestAnswerMessage(byte questType, byte result) {
		this.questType = questType;
		this.result = result;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.questType = reader.readSByte();
		if (questType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on questType = %s, it doesn't respect the following condition : questType < 0", questType));
		this.result = reader.readSByte();
		if (result < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on result = %s, it doesn't respect the following condition : result < 0", result));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.questType);
		writer.writeSByte(this.result);
	}
}