package org.chuckame.dofus2.protocol.types.game.paddock;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class PaddockInformations implements INetworkType {
	public static final short TYPE_ID = 132;
	
	private short maxOutdoorMount;
	private short maxItems;
	
	public PaddockInformations() {
	}
	
	public PaddockInformations(short maxOutdoorMount, short maxItems) {
		this.maxOutdoorMount = maxOutdoorMount;
		this.maxItems = maxItems;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.maxOutdoorMount = reader.readShort();
		if (maxOutdoorMount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxOutdoorMount = %s, it doesn't respect the following condition : maxOutdoorMount < 0", maxOutdoorMount));
		this.maxItems = reader.readShort();
		if (maxItems < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxItems = %s, it doesn't respect the following condition : maxItems < 0", maxItems));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.maxOutdoorMount);
		writer.writeShort(this.maxItems);
	}
}