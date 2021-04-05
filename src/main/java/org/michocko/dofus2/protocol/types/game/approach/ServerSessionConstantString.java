package org.michocko.dofus2.protocol.types.game.approach;

import org.michocko.dofus2.protocol.types.game.approach.ServerSessionConstant;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ServerSessionConstantString extends ServerSessionConstant {
	public static final short TYPE_ID = 436;
	
	private String value;
	
	public ServerSessionConstantString() {
	}
	
	public ServerSessionConstantString(short id, String value) {
		super(id);
		this.value = value;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.value = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.value);
	}
}