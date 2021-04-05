package org.michocko.dofus2.protocol.types.updater;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class ContentPart implements INetworkType {
	public static final short TYPE_ID = 350;
	
	private String id;
	private byte state;
	
	public ContentPart() {
	}
	
	public ContentPart(String id, byte state) {
		this.id = id;
		this.state = state;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readUTF();
		this.state = reader.readSByte();
		if (state < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on state = %s, it doesn't respect the following condition : state < 0", state));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.id);
		writer.writeSByte(this.state);
	}
}