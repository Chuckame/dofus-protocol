package org.chuckame.dofus2.protocol.types.game.context.fight;

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
public class FightLoot implements INetworkType {
	public static final short TYPE_ID = 41;
	
	private Collection<Short> objects;
	private int kamas;
	
	public FightLoot() {
	}
	
	public FightLoot(Collection<Short> objects, int kamas) {
		this.objects = objects;
		this.kamas = kamas;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.objects = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.objects.add(entry);
		}
		this.kamas = reader.readInt();
		if (kamas < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on kamas = %s, it doesn't respect the following condition : kamas < 0", kamas));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.objects.size());
		for (short entry : this.objects)
		{
			writer.writeShort(entry);
		}
		writer.writeInt(this.kamas);
	}
}