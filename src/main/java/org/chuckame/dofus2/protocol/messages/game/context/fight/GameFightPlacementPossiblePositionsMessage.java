package org.chuckame.dofus2.protocol.messages.game.context.fight;

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
public class GameFightPlacementPossiblePositionsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 703;
	
	private Collection<Short> positionsForChallengers;
	private Collection<Short> positionsForDefenders;
	private byte teamNumber;
	
	public GameFightPlacementPossiblePositionsMessage() {
	}
	
	public GameFightPlacementPossiblePositionsMessage(Collection<Short> positionsForChallengers, Collection<Short> positionsForDefenders, byte teamNumber) {
		this.positionsForChallengers = positionsForChallengers;
		this.positionsForDefenders = positionsForDefenders;
		this.teamNumber = teamNumber;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.positionsForChallengers = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.positionsForChallengers.add(entry);
		}
		length = reader.readUShort();
		this.positionsForDefenders = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.positionsForDefenders.add(entry);
		}
		this.teamNumber = reader.readSByte();
		if (teamNumber < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on teamNumber = %s, it doesn't respect the following condition : teamNumber < 0", teamNumber));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.positionsForChallengers.size());
		for (short entry : this.positionsForChallengers)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.positionsForDefenders.size());
		for (short entry : this.positionsForDefenders)
		{
			writer.writeShort(entry);
		}
		writer.writeSByte(this.teamNumber);
	}
}