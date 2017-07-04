package org.michocko.dofus2.protocol.types.game.guild;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class GuildEmblem implements INetworkType {
	public static final short TYPE_ID = 87;
	
	private short symbolShape;
	private int symbolColor;
	private short backgroundShape;
	private int backgroundColor;
	
	public GuildEmblem() {
	}
	
	public GuildEmblem(short symbolShape, int symbolColor, short backgroundShape, int backgroundColor) {
		this.symbolShape = symbolShape;
		this.symbolColor = symbolColor;
		this.backgroundShape = backgroundShape;
		this.backgroundColor = backgroundColor;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.symbolShape = reader.readShort();
		this.symbolColor = reader.readInt();
		this.backgroundShape = reader.readShort();
		this.backgroundColor = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.symbolShape);
		writer.writeInt(this.symbolColor);
		writer.writeShort(this.backgroundShape);
		writer.writeInt(this.backgroundColor);
	}
}