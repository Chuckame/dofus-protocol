package org.chuckame.dofus2.protocol.types.web.krosmaster;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class KrosmasterFigure implements INetworkType {
	public static final short TYPE_ID = 397;
	
	private String uid;
	private short figure;
	private short pedestal;
	private boolean bound;
	
	public KrosmasterFigure() {
	}
	
	public KrosmasterFigure(String uid, short figure, short pedestal, boolean bound) {
		this.uid = uid;
		this.figure = figure;
		this.pedestal = pedestal;
		this.bound = bound;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.uid = reader.readUTF();
		this.figure = reader.readShort();
		if (figure < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on figure = %s, it doesn't respect the following condition : figure < 0", figure));
		this.pedestal = reader.readShort();
		if (pedestal < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on pedestal = %s, it doesn't respect the following condition : pedestal < 0", pedestal));
		this.bound = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.uid);
		writer.writeShort(this.figure);
		writer.writeShort(this.pedestal);
		writer.writeBoolean(this.bound);
	}
}