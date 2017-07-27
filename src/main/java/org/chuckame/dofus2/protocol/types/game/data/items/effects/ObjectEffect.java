package org.chuckame.dofus2.protocol.types.game.data.items.effects;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class ObjectEffect implements INetworkType {
	public static final short TYPE_ID = 76;
	
	private short actionId;
	
	public ObjectEffect() {
	}
	
	public ObjectEffect(short actionId) {
		this.actionId = actionId;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.actionId = reader.readShort();
		if (actionId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on actionId = %s, it doesn't respect the following condition : actionId < 0", actionId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.actionId);
	}
}