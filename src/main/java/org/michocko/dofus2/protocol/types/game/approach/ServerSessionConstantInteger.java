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
public class ServerSessionConstantInteger extends ServerSessionConstant {
	public static final short TYPE_ID = 433;
	
	private int value;
	
	public ServerSessionConstantInteger() {
	}
	
	public ServerSessionConstantInteger(short id, int value) {
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
		this.value = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.value);
	}
}