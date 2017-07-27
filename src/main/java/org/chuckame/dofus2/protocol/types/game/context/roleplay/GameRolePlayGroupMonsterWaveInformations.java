package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GameRolePlayGroupMonsterInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GroupMonsterStaticInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameRolePlayGroupMonsterWaveInformations extends GameRolePlayGroupMonsterInformations {
	public static final short TYPE_ID = 464;
	
	private long nbWaves;
	private Collection<GroupMonsterStaticInformations> alternatives;
	
	public GameRolePlayGroupMonsterWaveInformations() {
	}
	
	public GameRolePlayGroupMonsterWaveInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, GroupMonsterStaticInformations staticInfos, short ageBonus, byte lootShare, byte alignmentSide, long nbWaves, Collection<GroupMonsterStaticInformations> alternatives) {
		super(contextualId, look, disposition, staticInfos, ageBonus, lootShare, alignmentSide);
		this.nbWaves = nbWaves;
		this.alternatives = alternatives;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.nbWaves = reader.readUInt();
		if (nbWaves < 0 || nbWaves > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on nbWaves = %s, it doesn't respect the following condition : nbWaves < 0 || nbWaves > 4.294967295E9", nbWaves));
		int length = reader.readUShort();
		this.alternatives = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GroupMonsterStaticInformations entry = new GroupMonsterStaticInformations();
			entry.deserialize(reader);
			this.alternatives.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUInt(this.nbWaves);
		writer.writeUShort(this.alternatives.size());
		for (GroupMonsterStaticInformations entry : this.alternatives)
		{
			entry.serialize(writer);
		}
	}
}