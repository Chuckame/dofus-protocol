package org.chuckame.dofus2.protocol.types.game.achievement;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class AchievementRewardable implements INetworkType {
	public static final short TYPE_ID = 412;
	
	private short id;
	private short finishedlevel;
	
	public AchievementRewardable() {
	}
	
	public AchievementRewardable(short id, short finishedlevel) {
		this.id = id;
		this.finishedlevel = finishedlevel;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readShort();
		if (id < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0", id));
		this.finishedlevel = reader.readShort();
		if (finishedlevel < 0 || finishedlevel > 200)
			throw new IllegalArgumentException(String.format("Forbidden value on finishedlevel = %s, it doesn't respect the following condition : finishedlevel < 0 || finishedlevel > 200", finishedlevel));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.id);
		writer.writeShort(this.finishedlevel);
	}
}