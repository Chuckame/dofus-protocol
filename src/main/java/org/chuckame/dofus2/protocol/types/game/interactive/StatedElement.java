package org.chuckame.dofus2.protocol.types.game.interactive;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class StatedElement implements INetworkType {
	public static final short TYPE_ID = 108;
	
	private int elementId;
	private short elementCellId;
	private int elementState;
	
	public StatedElement() {
	}
	
	public StatedElement(int elementId, short elementCellId, int elementState) {
		this.elementId = elementId;
		this.elementCellId = elementCellId;
		this.elementState = elementState;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.elementId = reader.readInt();
		if (elementId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on elementId = %s, it doesn't respect the following condition : elementId < 0", elementId));
		this.elementCellId = reader.readShort();
		if (elementCellId < 0 || elementCellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on elementCellId = %s, it doesn't respect the following condition : elementCellId < 0 || elementCellId > 559", elementCellId));
		this.elementState = reader.readInt();
		if (elementState < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on elementState = %s, it doesn't respect the following condition : elementState < 0", elementState));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.elementId);
		writer.writeShort(this.elementCellId);
		writer.writeInt(this.elementState);
	}
}