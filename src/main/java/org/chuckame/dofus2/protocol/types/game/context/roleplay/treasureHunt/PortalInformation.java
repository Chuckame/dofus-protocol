package org.chuckame.dofus2.protocol.types.game.context.roleplay.treasureHunt;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class PortalInformation implements INetworkType {
	public static final short TYPE_ID = 466;
	
	private short portalId;
	private short areaId;
	
	public PortalInformation() {
	}
	
	public PortalInformation(short portalId, short areaId) {
		this.portalId = portalId;
		this.areaId = areaId;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.portalId = reader.readShort();
		if (portalId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on portalId = %s, it doesn't respect the following condition : portalId < 0", portalId));
		this.areaId = reader.readShort();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.portalId);
		writer.writeShort(this.areaId);
	}
}