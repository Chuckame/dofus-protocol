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
public class ServerSessionConstantLong extends ServerSessionConstant {
	public static final short TYPE_ID = 429;
	
	private double value;
	
	public ServerSessionConstantLong() {
	}
	
	public ServerSessionConstantLong(short id, double value) {
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
		this.value = reader.readDouble();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeDouble(this.value);
	}
}