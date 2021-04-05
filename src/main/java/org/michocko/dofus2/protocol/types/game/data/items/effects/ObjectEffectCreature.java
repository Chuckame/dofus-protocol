package org.michocko.dofus2.protocol.types.game.data.items.effects;

import org.michocko.dofus2.protocol.types.game.data.items.effects.ObjectEffect;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ObjectEffectCreature extends ObjectEffect {
	public static final short TYPE_ID = 71;
	
	private short monsterFamilyId;
	
	public ObjectEffectCreature() {
	}
	
	public ObjectEffectCreature(short actionId, short monsterFamilyId) {
		super(actionId);
		this.monsterFamilyId = monsterFamilyId;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.monsterFamilyId = reader.readShort();
		if (monsterFamilyId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on monsterFamilyId = %s, it doesn't respect the following condition : monsterFamilyId < 0", monsterFamilyId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.monsterFamilyId);
	}
}