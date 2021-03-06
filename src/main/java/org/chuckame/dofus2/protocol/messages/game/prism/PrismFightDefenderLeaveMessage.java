package org.chuckame.dofus2.protocol.messages.game.prism;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PrismFightDefenderLeaveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5892;
	
	private short subAreaId;
	private double fightId;
	private int fighterToRemoveId;
	
	public PrismFightDefenderLeaveMessage() {
	}
	
	public PrismFightDefenderLeaveMessage(short subAreaId, double fightId, int fighterToRemoveId) {
		this.subAreaId = subAreaId;
		this.fightId = fightId;
		this.fighterToRemoveId = fighterToRemoveId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.fightId = reader.readDouble();
		this.fighterToRemoveId = reader.readInt();
		if (fighterToRemoveId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fighterToRemoveId = %s, it doesn't respect the following condition : fighterToRemoveId < 0", fighterToRemoveId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.subAreaId);
		writer.writeDouble(this.fightId);
		writer.writeInt(this.fighterToRemoveId);
	}
}