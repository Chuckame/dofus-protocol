package org.michocko.dofus2.protocol.types.game.achievement;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class AchievementObjective implements INetworkType {
	public static final short TYPE_ID = 404;
	
	private int id;
	private short maxValue;
	
	public AchievementObjective() {
	}
	
	public AchievementObjective(int id, short maxValue) {
		this.id = id;
		this.maxValue = maxValue;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
		if (id < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0", id));
		this.maxValue = reader.readShort();
		if (maxValue < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxValue = %s, it doesn't respect the following condition : maxValue < 0", maxValue));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
		writer.writeShort(this.maxValue);
	}
}