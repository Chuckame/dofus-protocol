package org.chuckame.dofus2.protocol.types.connection;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class GameServerInformations implements INetworkType {
	public static final short TYPE_ID = 25;
	
	private int id;
	private byte status;
	private byte completion;
	private boolean isSelectable;
	private byte charactersCount;
	private double date;
	
	public GameServerInformations() {
	}
	
	public GameServerInformations(int id, byte status, byte completion, boolean isSelectable, byte charactersCount, double date) {
		this.id = id;
		this.status = status;
		this.completion = completion;
		this.isSelectable = isSelectable;
		this.charactersCount = charactersCount;
		this.date = date;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readUShort();
		if (id < 0 || id > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0 || id > 65535", id));
		this.status = reader.readSByte();
		if (status < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on status = %s, it doesn't respect the following condition : status < 0", status));
		this.completion = reader.readSByte();
		if (completion < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on completion = %s, it doesn't respect the following condition : completion < 0", completion));
		this.isSelectable = reader.readBoolean();
		this.charactersCount = reader.readSByte();
		if (charactersCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on charactersCount = %s, it doesn't respect the following condition : charactersCount < 0", charactersCount));
		this.date = reader.readDouble();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.id);
		writer.writeSByte(this.status);
		writer.writeSByte(this.completion);
		writer.writeBoolean(this.isSelectable);
		writer.writeSByte(this.charactersCount);
		writer.writeDouble(this.date);
	}
}