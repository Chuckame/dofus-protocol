package org.michocko.dofus2.protocol.types.game.fight;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class ProtectedEntityWaitingForHelpInfo implements INetworkType {
	public static final short TYPE_ID = 186;
	
	private int timeLeftBeforeFight;
	private int waitTimeForPlacement;
	private byte nbPositionForDefensors;
	
	public ProtectedEntityWaitingForHelpInfo() {
	}
	
	public ProtectedEntityWaitingForHelpInfo(int timeLeftBeforeFight, int waitTimeForPlacement, byte nbPositionForDefensors) {
		this.timeLeftBeforeFight = timeLeftBeforeFight;
		this.waitTimeForPlacement = waitTimeForPlacement;
		this.nbPositionForDefensors = nbPositionForDefensors;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.timeLeftBeforeFight = reader.readInt();
		this.waitTimeForPlacement = reader.readInt();
		this.nbPositionForDefensors = reader.readSByte();
		if (nbPositionForDefensors < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbPositionForDefensors = %s, it doesn't respect the following condition : nbPositionForDefensors < 0", nbPositionForDefensors));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.timeLeftBeforeFight);
		writer.writeInt(this.waitTimeForPlacement);
		writer.writeSByte(this.nbPositionForDefensors);
	}
}