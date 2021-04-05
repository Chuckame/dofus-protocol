package org.michocko.dofus2.protocol.types.game.prism;

import org.michocko.dofus2.protocol.types.game.prism.PrismInformation;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class AllianceInsiderPrismInformation extends PrismInformation {
	public static final short TYPE_ID = 431;
	
	private int lastTimeSlotModificationDate;
	private int lastTimeSlotModificationAuthorGuildId;
	private int lastTimeSlotModificationAuthorId;
	private String lastTimeSlotModificationAuthorName;
	private boolean hasTeleporterModule;
	
	public AllianceInsiderPrismInformation() {
	}
	
	public AllianceInsiderPrismInformation(byte typeId, byte state, int nextVulnerabilityDate, int placementDate, int rewardTokenCount, int lastTimeSlotModificationDate, int lastTimeSlotModificationAuthorGuildId, int lastTimeSlotModificationAuthorId, String lastTimeSlotModificationAuthorName, boolean hasTeleporterModule) {
		super(typeId, state, nextVulnerabilityDate, placementDate, rewardTokenCount);
		this.lastTimeSlotModificationDate = lastTimeSlotModificationDate;
		this.lastTimeSlotModificationAuthorGuildId = lastTimeSlotModificationAuthorGuildId;
		this.lastTimeSlotModificationAuthorId = lastTimeSlotModificationAuthorId;
		this.lastTimeSlotModificationAuthorName = lastTimeSlotModificationAuthorName;
		this.hasTeleporterModule = hasTeleporterModule;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.lastTimeSlotModificationDate = reader.readInt();
		if (lastTimeSlotModificationDate < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lastTimeSlotModificationDate = %s, it doesn't respect the following condition : lastTimeSlotModificationDate < 0", lastTimeSlotModificationDate));
		this.lastTimeSlotModificationAuthorGuildId = reader.readInt();
		if (lastTimeSlotModificationAuthorGuildId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lastTimeSlotModificationAuthorGuildId = %s, it doesn't respect the following condition : lastTimeSlotModificationAuthorGuildId < 0", lastTimeSlotModificationAuthorGuildId));
		this.lastTimeSlotModificationAuthorId = reader.readInt();
		if (lastTimeSlotModificationAuthorId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lastTimeSlotModificationAuthorId = %s, it doesn't respect the following condition : lastTimeSlotModificationAuthorId < 0", lastTimeSlotModificationAuthorId));
		this.lastTimeSlotModificationAuthorName = reader.readUTF();
		this.hasTeleporterModule = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.lastTimeSlotModificationDate);
		writer.writeInt(this.lastTimeSlotModificationAuthorGuildId);
		writer.writeInt(this.lastTimeSlotModificationAuthorId);
		writer.writeUTF(this.lastTimeSlotModificationAuthorName);
		writer.writeBoolean(this.hasTeleporterModule);
	}
}