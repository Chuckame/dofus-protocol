package org.chuckame.dofus2.protocol.types.game.interactive;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.interactive.InteractiveElement;
import org.chuckame.dofus2.protocol.types.game.interactive.InteractiveElementSkill;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class InteractiveElementWithAgeBonus extends InteractiveElement {
	public static final short TYPE_ID = 398;
	
	private short ageBonus;
	
	public InteractiveElementWithAgeBonus() {
	}
	
	public InteractiveElementWithAgeBonus(int elementId, int elementTypeId, Collection<InteractiveElementSkill> enabledSkills, Collection<InteractiveElementSkill> disabledSkills, short ageBonus) {
		super(elementId, elementTypeId, enabledSkills, disabledSkills);
		this.ageBonus = ageBonus;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.ageBonus = reader.readShort();
		if (ageBonus < -1 || ageBonus > 1000)
			throw new IllegalArgumentException(String.format("Forbidden value on ageBonus = %s, it doesn't respect the following condition : ageBonus < -1 || ageBonus > 1000", ageBonus));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.ageBonus);
	}
}