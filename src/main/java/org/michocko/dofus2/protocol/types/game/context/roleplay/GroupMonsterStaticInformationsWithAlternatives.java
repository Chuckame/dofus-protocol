package org.michocko.dofus2.protocol.types.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.AlternativeMonstersInGroupLightInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.MonsterInGroupLightInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.MonsterInGroupInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.GroupMonsterStaticInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GroupMonsterStaticInformationsWithAlternatives extends GroupMonsterStaticInformations {
	public static final short TYPE_ID = 396;
	
	private Collection<AlternativeMonstersInGroupLightInformations> alternatives;
	
	public GroupMonsterStaticInformationsWithAlternatives() {
	}
	
	public GroupMonsterStaticInformationsWithAlternatives(MonsterInGroupLightInformations mainCreatureLightInfos, Collection<MonsterInGroupInformations> underlings, Collection<AlternativeMonstersInGroupLightInformations> alternatives) {
		super(mainCreatureLightInfos, underlings);
		this.alternatives = alternatives;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.alternatives = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			AlternativeMonstersInGroupLightInformations entry = new AlternativeMonstersInGroupLightInformations();
			entry.deserialize(reader);
			this.alternatives.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.alternatives.size());
		for (AlternativeMonstersInGroupLightInformations entry : this.alternatives)
		{
			entry.serialize(writer);
		}
	}
}