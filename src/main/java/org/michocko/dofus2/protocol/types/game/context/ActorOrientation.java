package org.michocko.dofus2.protocol.types.game.context;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class ActorOrientation implements INetworkType {
	public static final short TYPE_ID = 353;
	
	private int id;
	private byte direction;
	
	public ActorOrientation() {
	}
	
	public ActorOrientation(int id, byte direction) {
		this.id = id;
		this.direction = direction;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
		this.direction = reader.readSByte();
		if (direction < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on direction = %s, it doesn't respect the following condition : direction < 0", direction));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
		writer.writeSByte(this.direction);
	}
}