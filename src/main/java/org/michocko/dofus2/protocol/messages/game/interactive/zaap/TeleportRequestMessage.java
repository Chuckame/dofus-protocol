package org.michocko.dofus2.protocol.messages.game.interactive.zaap;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TeleportRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5961;
	
	private byte teleporterType;
	private int mapId;
	
	public TeleportRequestMessage() {
	}
	
	public TeleportRequestMessage(byte teleporterType, int mapId) {
		this.teleporterType = teleporterType;
		this.mapId = mapId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.teleporterType = reader.readSByte();
		if (teleporterType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on teleporterType = %s, it doesn't respect the following condition : teleporterType < 0", teleporterType));
		this.mapId = reader.readInt();
		if (mapId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on mapId = %s, it doesn't respect the following condition : mapId < 0", mapId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.teleporterType);
		writer.writeInt(this.mapId);
	}
}