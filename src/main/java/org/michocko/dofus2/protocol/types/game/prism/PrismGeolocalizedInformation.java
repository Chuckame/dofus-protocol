package org.michocko.dofus2.protocol.types.game.prism;

import org.michocko.dofus2.protocol.types.game.prism.PrismInformation;
import org.michocko.dofus2.protocol.types.game.prism.PrismSubareaEmptyInfo;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class PrismGeolocalizedInformation extends PrismSubareaEmptyInfo {
	public static final short TYPE_ID = 434;
	
	private short worldX;
	private short worldY;
	private int mapId;
	private PrismInformation prism;
	
	public PrismGeolocalizedInformation() {
	}
	
	public PrismGeolocalizedInformation(short subAreaId, int allianceId, short worldX, short worldY, int mapId, PrismInformation prism) {
		super(subAreaId, allianceId);
		this.worldX = worldX;
		this.worldY = worldY;
		this.mapId = mapId;
		this.prism = prism;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.worldX = reader.readShort();
		if (worldX < -255 || worldX > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldX = %s, it doesn't respect the following condition : worldX < -255 || worldX > 255", worldX));
		this.worldY = reader.readShort();
		if (worldY < -255 || worldY > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldY = %s, it doesn't respect the following condition : worldY < -255 || worldY > 255", worldY));
		this.mapId = reader.readInt();
		this.prism = ProtocolTypeManager.getInstance().<PrismInformation>newInstance(reader.readShort());
		this.prism.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeInt(this.mapId);
		writer.writeShort(this.prism.getNetworkTypeId());
		this.prism.serialize(writer);
	}
}