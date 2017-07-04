package org.michocko.dofus2.protocol.messages.game.interactive.zaap;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.messages.game.interactive.zaap.TeleportDestinationsListMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ZaapListMessage extends TeleportDestinationsListMessage {
	public static final int MESSAGE_ID = 1604;
	
	private int spawnMapId;
	
	public ZaapListMessage() {
	}
	
	public ZaapListMessage(byte teleporterType, Collection<Integer> mapIds, Collection<Short> subAreaIds, Collection<Short> costs, Collection<Byte> destTeleporterType, int spawnMapId) {
		super(teleporterType, mapIds, subAreaIds, costs, destTeleporterType);
		this.spawnMapId = spawnMapId;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.spawnMapId = reader.readInt();
		if (spawnMapId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spawnMapId = %s, it doesn't respect the following condition : spawnMapId < 0", spawnMapId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.spawnMapId);
	}
}