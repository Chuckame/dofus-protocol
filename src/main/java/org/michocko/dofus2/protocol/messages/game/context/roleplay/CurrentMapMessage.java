package org.michocko.dofus2.protocol.messages.game.context.roleplay;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CurrentMapMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 220;
	
	private int mapId;
	private String mapKey;
	
	public CurrentMapMessage() {
	}
	
	public CurrentMapMessage(int mapId, String mapKey) {
		this.mapId = mapId;
		this.mapKey = mapKey;
	}
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.mapId = reader.readInt();
		if (mapId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on mapId = %s, it doesn't respect the following condition : mapId < 0", mapId));
		this.mapKey = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.mapId);
		writer.writeUTF(this.mapKey);
	}
}