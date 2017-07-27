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
public class PrismFightDefendersSwapMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5902;
	
	private short subAreaId;
	private double fightId;
	private int fighterId1;
	private int fighterId2;
	
	public PrismFightDefendersSwapMessage() {
	}
	
	public PrismFightDefendersSwapMessage(short subAreaId, double fightId, int fighterId1, int fighterId2) {
		this.subAreaId = subAreaId;
		this.fightId = fightId;
		this.fighterId1 = fighterId1;
		this.fighterId2 = fighterId2;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.fightId = reader.readDouble();
		this.fighterId1 = reader.readInt();
		if (fighterId1 < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fighterId1 = %s, it doesn't respect the following condition : fighterId1 < 0", fighterId1));
		this.fighterId2 = reader.readInt();
		if (fighterId2 < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fighterId2 = %s, it doesn't respect the following condition : fighterId2 < 0", fighterId2));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.subAreaId);
		writer.writeDouble(this.fightId);
		writer.writeInt(this.fighterId1);
		writer.writeInt(this.fighterId2);
	}
}