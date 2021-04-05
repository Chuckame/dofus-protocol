package org.michocko.dofus2.protocol.types.game.prism;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class PrismSubareaEmptyInfo implements INetworkType {
	public static final short TYPE_ID = 438;
	
	private short subAreaId;
	private int allianceId;
	
	public PrismSubareaEmptyInfo() {
	}
	
	public PrismSubareaEmptyInfo(short subAreaId, int allianceId) {
		this.subAreaId = subAreaId;
		this.allianceId = allianceId;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.allianceId = reader.readInt();
		if (allianceId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on allianceId = %s, it doesn't respect the following condition : allianceId < 0", allianceId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.subAreaId);
		writer.writeInt(this.allianceId);
	}
}