package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class GameFightFighterLightInformations implements INetworkType {
	public static final short TYPE_ID = 413;
	
	private int id;
	private int wave;
	private short level;
	private byte breed;
	
	public GameFightFighterLightInformations() {
	}
	
	public GameFightFighterLightInformations(int id, int wave, short level, byte breed) {
		this.id = id;
		this.wave = wave;
		this.level = level;
		this.breed = breed;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
		this.wave = reader.readInt();
		this.level = reader.readShort();
		if (level < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0", level));
		this.breed = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
		writer.writeInt(this.wave);
		writer.writeShort(this.level);
		writer.writeSByte(this.breed);
	}
}