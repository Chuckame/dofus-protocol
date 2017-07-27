package org.chuckame.dofus2.protocol.messages.game.atlas.compass;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.MapCoordinates;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CompassUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5591;
	
	private byte type;
	private MapCoordinates coords;
	
	public CompassUpdateMessage() {
	}
	
	public CompassUpdateMessage(byte type, MapCoordinates coords) {
		this.type = type;
		this.coords = coords;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.type = reader.readSByte();
		if (type < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on type = %s, it doesn't respect the following condition : type < 0", type));
		this.coords = ProtocolTypeManager.getInstance().<MapCoordinates>newInstance(reader.readShort());
		this.coords.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.type);
		writer.writeShort(this.coords.getProtocolTypeId());
		this.coords.serialize(writer);
	}
}