package org.chuckame.dofus2.protocol.types.game.prism;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class PrismInformation implements INetworkType {
	public static final short TYPE_ID = 428;
	
	private byte typeId;
	private byte state;
	private int nextVulnerabilityDate;
	private int placementDate;
	private int rewardTokenCount;
	
	public PrismInformation() {
	}
	
	public PrismInformation(byte typeId, byte state, int nextVulnerabilityDate, int placementDate, int rewardTokenCount) {
		this.typeId = typeId;
		this.state = state;
		this.nextVulnerabilityDate = nextVulnerabilityDate;
		this.placementDate = placementDate;
		this.rewardTokenCount = rewardTokenCount;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.typeId = reader.readSByte();
		if (typeId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on typeId = %s, it doesn't respect the following condition : typeId < 0", typeId));
		this.state = reader.readSByte();
		if (state < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on state = %s, it doesn't respect the following condition : state < 0", state));
		this.nextVulnerabilityDate = reader.readInt();
		if (nextVulnerabilityDate < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nextVulnerabilityDate = %s, it doesn't respect the following condition : nextVulnerabilityDate < 0", nextVulnerabilityDate));
		this.placementDate = reader.readInt();
		if (placementDate < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on placementDate = %s, it doesn't respect the following condition : placementDate < 0", placementDate));
		this.rewardTokenCount = reader.readInt();
		if (rewardTokenCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on rewardTokenCount = %s, it doesn't respect the following condition : rewardTokenCount < 0", rewardTokenCount));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.typeId);
		writer.writeSByte(this.state);
		writer.writeInt(this.nextVulnerabilityDate);
		writer.writeInt(this.placementDate);
		writer.writeInt(this.rewardTokenCount);
	}
}