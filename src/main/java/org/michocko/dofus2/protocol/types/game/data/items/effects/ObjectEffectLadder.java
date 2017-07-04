package org.michocko.dofus2.protocol.types.game.data.items.effects;

import org.michocko.dofus2.protocol.types.game.data.items.effects.ObjectEffectCreature;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ObjectEffectLadder extends ObjectEffectCreature {
	public static final short TYPE_ID = 81;
	
	private int monsterCount;
	
	public ObjectEffectLadder() {
	}
	
	public ObjectEffectLadder(short actionId, short monsterFamilyId, int monsterCount) {
		super(actionId, monsterFamilyId);
		this.monsterCount = monsterCount;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.monsterCount = reader.readInt();
		if (monsterCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on monsterCount = %s, it doesn't respect the following condition : monsterCount < 0", monsterCount));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.monsterCount);
	}
}