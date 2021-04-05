package org.michocko.dofus2.protocol.types.game.inventory.preset;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class PresetItem implements INetworkType {
	public static final short TYPE_ID = 354;
	
	private short position;
	private int objGid;
	private int objUid;
	
	public PresetItem() {
	}
	
	public PresetItem(short position, int objGid, int objUid) {
		this.position = position;
		this.objGid = objGid;
		this.objUid = objUid;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.position = reader.readByte();
		if (position < 0 || position > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on position = %s, it doesn't respect the following condition : position < 0 || position > 255", position));
		this.objGid = reader.readInt();
		if (objGid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objGid = %s, it doesn't respect the following condition : objGid < 0", objGid));
		this.objUid = reader.readInt();
		if (objUid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objUid = %s, it doesn't respect the following condition : objUid < 0", objUid));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeByte(this.position);
		writer.writeInt(this.objGid);
		writer.writeInt(this.objUid);
	}
}