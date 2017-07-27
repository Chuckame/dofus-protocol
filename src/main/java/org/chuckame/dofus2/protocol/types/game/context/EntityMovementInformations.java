package org.chuckame.dofus2.protocol.types.game.context;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class EntityMovementInformations implements INetworkType {
	public static final short TYPE_ID = 63;
	
	private int id;
	private Collection<Byte> steps;
	
	public EntityMovementInformations() {
	}
	
	public EntityMovementInformations(int id, Collection<Byte> steps) {
		this.id = id;
		this.steps = steps;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
		int length = reader.readUShort();
		this.steps = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			byte entry = reader.readSByte();
			this.steps.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
		writer.writeUShort(this.steps.size());
		for (byte entry : this.steps)
		{
			writer.writeSByte(entry);
		}
	}
}