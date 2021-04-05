package org.michocko.dofus2.protocol.types.game.context.roleplay;

import org.michocko.dofus2.protocol.types.game.context.roleplay.HumanOption;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class HumanOptionObjectUse extends HumanOption {
	public static final short TYPE_ID = 449;
	
	private byte delayTypeId;
	private double delayEndTime;
	private short objectGID;
	
	public HumanOptionObjectUse() {
	}
	
	public HumanOptionObjectUse(byte delayTypeId, double delayEndTime, short objectGID) {
		this.delayTypeId = delayTypeId;
		this.delayEndTime = delayEndTime;
		this.objectGID = objectGID;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.delayTypeId = reader.readSByte();
		if (delayTypeId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on delayTypeId = %s, it doesn't respect the following condition : delayTypeId < 0", delayTypeId));
		this.delayEndTime = reader.readDouble();
		if (delayEndTime < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on delayEndTime = %s, it doesn't respect the following condition : delayEndTime < 0", delayEndTime));
		this.objectGID = reader.readShort();
		if (objectGID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectGID = %s, it doesn't respect the following condition : objectGID < 0", objectGID));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.delayTypeId);
		writer.writeDouble(this.delayEndTime);
		writer.writeShort(this.objectGID);
	}
}