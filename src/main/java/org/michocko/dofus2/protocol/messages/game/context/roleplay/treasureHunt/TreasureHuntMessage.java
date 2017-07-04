package org.michocko.dofus2.protocol.messages.game.context.roleplay.treasureHunt;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.treasureHunt.TreasureHuntStep;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TreasureHuntMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6486;
	
	private byte questType;
	private int startMapId;
	private Collection<TreasureHuntStep> stepList;
	private int checkPointCurrent;
	private int checkPointTotal;
	private int availableRetryCount;
	
	public TreasureHuntMessage() {
	}
	
	public TreasureHuntMessage(byte questType, int startMapId, Collection<TreasureHuntStep> stepList, int checkPointCurrent, int checkPointTotal, int availableRetryCount) {
		this.questType = questType;
		this.startMapId = startMapId;
		this.stepList = stepList;
		this.checkPointCurrent = checkPointCurrent;
		this.checkPointTotal = checkPointTotal;
		this.availableRetryCount = availableRetryCount;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.questType = reader.readSByte();
		if (questType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on questType = %s, it doesn't respect the following condition : questType < 0", questType));
		this.startMapId = reader.readInt();
		if (startMapId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on startMapId = %s, it doesn't respect the following condition : startMapId < 0", startMapId));
		int length = reader.readUShort();
		this.stepList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			TreasureHuntStep entry = ProtocolTypeManager.getInstance().<TreasureHuntStep>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.stepList.add(entry);
		}
		this.checkPointCurrent = reader.readInt();
		if (checkPointCurrent < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on checkPointCurrent = %s, it doesn't respect the following condition : checkPointCurrent < 0", checkPointCurrent));
		this.checkPointTotal = reader.readInt();
		if (checkPointTotal < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on checkPointTotal = %s, it doesn't respect the following condition : checkPointTotal < 0", checkPointTotal));
		this.availableRetryCount = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.questType);
		writer.writeInt(this.startMapId);
		writer.writeUShort(this.stepList.size());
		for (TreasureHuntStep entry : this.stepList)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
		writer.writeInt(this.checkPointCurrent);
		writer.writeInt(this.checkPointTotal);
		writer.writeInt(this.availableRetryCount);
	}
}