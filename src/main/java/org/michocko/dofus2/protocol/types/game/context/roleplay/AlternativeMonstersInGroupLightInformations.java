package org.michocko.dofus2.protocol.types.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.MonsterInGroupLightInformations;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class AlternativeMonstersInGroupLightInformations implements INetworkType {
	public static final short TYPE_ID = 394;
	
	private int playerCount;
	private Collection<MonsterInGroupLightInformations> monsters;
	
	public AlternativeMonstersInGroupLightInformations() {
	}
	
	public AlternativeMonstersInGroupLightInformations(int playerCount, Collection<MonsterInGroupLightInformations> monsters) {
		this.playerCount = playerCount;
		this.monsters = monsters;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.playerCount = reader.readInt();
		int length = reader.readUShort();
		this.monsters = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			MonsterInGroupLightInformations entry = new MonsterInGroupLightInformations();
			entry.deserialize(reader);
			this.monsters.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.playerCount);
		writer.writeUShort(this.monsters.size());
		for (MonsterInGroupLightInformations entry : this.monsters)
		{
			entry.serialize(writer);
		}
	}
}