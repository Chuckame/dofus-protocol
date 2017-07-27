package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class MonsterInGroupLightInformations implements INetworkType {
	public static final short TYPE_ID = 395;
	
	private int creatureGenericId;
	private byte grade;
	
	public MonsterInGroupLightInformations() {
	}
	
	public MonsterInGroupLightInformations(int creatureGenericId, byte grade) {
		this.creatureGenericId = creatureGenericId;
		this.grade = grade;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.creatureGenericId = reader.readInt();
		this.grade = reader.readSByte();
		if (grade < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on grade = %s, it doesn't respect the following condition : grade < 0", grade));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.creatureGenericId);
		writer.writeSByte(this.grade);
	}
}