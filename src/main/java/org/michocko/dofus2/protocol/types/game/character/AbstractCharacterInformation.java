package org.michocko.dofus2.protocol.types.game.character;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class AbstractCharacterInformation implements INetworkType {
	public static final short TYPE_ID = 400;
	
	private int id;
	
	public AbstractCharacterInformation() {
	}
	
	public AbstractCharacterInformation(int id) {
		this.id = id;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
		if (id < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0", id));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
	}
}