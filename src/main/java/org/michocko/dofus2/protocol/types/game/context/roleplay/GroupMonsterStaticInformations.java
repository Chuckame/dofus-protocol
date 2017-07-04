package org.michocko.dofus2.protocol.types.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.MonsterInGroupLightInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.MonsterInGroupInformations;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class GroupMonsterStaticInformations implements INetworkType {
	public static final short TYPE_ID = 140;
	
	private MonsterInGroupLightInformations mainCreatureLightInfos;
	private Collection<MonsterInGroupInformations> underlings;
	
	public GroupMonsterStaticInformations() {
	}
	
	public GroupMonsterStaticInformations(MonsterInGroupLightInformations mainCreatureLightInfos, Collection<MonsterInGroupInformations> underlings) {
		this.mainCreatureLightInfos = mainCreatureLightInfos;
		this.underlings = underlings;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mainCreatureLightInfos = new MonsterInGroupLightInformations();
		this.mainCreatureLightInfos.deserialize(reader);
		int length = reader.readUShort();
		this.underlings = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			MonsterInGroupInformations entry = new MonsterInGroupInformations();
			entry.deserialize(reader);
			this.underlings.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		this.mainCreatureLightInfos.serialize(writer);
		writer.writeUShort(this.underlings.size());
		for (MonsterInGroupInformations entry : this.underlings)
		{
			entry.serialize(writer);
		}
	}
}