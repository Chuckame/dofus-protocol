package org.chuckame.dofus2.protocol.types.game.approach;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.approach.ServerSessionConstant;

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
	public short getProtocolTypeId() {
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