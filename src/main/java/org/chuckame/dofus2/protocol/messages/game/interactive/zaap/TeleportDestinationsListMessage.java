package org.chuckame.dofus2.protocol.messages.game.interactive.zaap;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TeleportDestinationsListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5960;
	
	private byte teleporterType;
	private Collection<Integer> mapIds;
	private Collection<Short> subAreaIds;
	private Collection<Short> costs;
	private Collection<Byte> destTeleporterType;
	
	public TeleportDestinationsListMessage() {
	}
	
	public TeleportDestinationsListMessage(byte teleporterType, Collection<Integer> mapIds, Collection<Short> subAreaIds, Collection<Short> costs, Collection<Byte> destTeleporterType) {
		this.teleporterType = teleporterType;
		this.mapIds = mapIds;
		this.subAreaIds = subAreaIds;
		this.costs = costs;
		this.destTeleporterType = destTeleporterType;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.teleporterType = reader.readSByte();
		if (teleporterType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on teleporterType = %s, it doesn't respect the following condition : teleporterType < 0", teleporterType));
		int length = reader.readUShort();
		this.mapIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.mapIds.add(entry);
		}
		length = reader.readUShort();
		this.subAreaIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.subAreaIds.add(entry);
		}
		length = reader.readUShort();
		this.costs = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.costs.add(entry);
		}
		length = reader.readUShort();
		this.destTeleporterType = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			byte entry = reader.readSByte();
			this.destTeleporterType.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.teleporterType);
		writer.writeUShort(this.mapIds.size());
		for (int entry : this.mapIds)
		{
			writer.writeInt(entry);
		}
		writer.writeUShort(this.subAreaIds.size());
		for (short entry : this.subAreaIds)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.costs.size());
		for (short entry : this.costs)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.destTeleporterType.size());
		for (byte entry : this.destTeleporterType)
		{
			writer.writeSByte(entry);
		}
	}
}