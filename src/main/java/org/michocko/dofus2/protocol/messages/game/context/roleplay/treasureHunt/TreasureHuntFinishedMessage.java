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
public class TreasureHuntFinishedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6483;
	
	private byte questType;
	
	public TreasureHuntFinishedMessage() {
	}
	
	public TreasureHuntFinishedMessage(byte questType) {
		this.questType = questType;
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
		this.questType = reader.readSByte();
		if (questType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on questType = %s, it doesn't respect the following condition : questType < 0", questType));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.questType);
	}
}