package org.michocko.dofus2.protocol.types.game.interactive;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.interactive.InteractiveElementSkill;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class InteractiveElement implements INetworkType {
	public static final short TYPE_ID = 80;
	
	private int elementId;
	private int elementTypeId;
	private Collection<InteractiveElementSkill> enabledSkills;
	private Collection<InteractiveElementSkill> disabledSkills;
	
	public InteractiveElement() {
	}
	
	public InteractiveElement(int elementId, int elementTypeId, Collection<InteractiveElementSkill> enabledSkills, Collection<InteractiveElementSkill> disabledSkills) {
		this.elementId = elementId;
		this.elementTypeId = elementTypeId;
		this.enabledSkills = enabledSkills;
		this.disabledSkills = disabledSkills;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.elementId = reader.readInt();
		if (elementId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on elementId = %s, it doesn't respect the following condition : elementId < 0", elementId));
		this.elementTypeId = reader.readInt();
		int length = reader.readUShort();
		this.enabledSkills = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			InteractiveElementSkill entry = ProtocolTypeManager.getInstance().<InteractiveElementSkill>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.enabledSkills.add(entry);
		}
		length = reader.readUShort();
		this.disabledSkills = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			InteractiveElementSkill entry = ProtocolTypeManager.getInstance().<InteractiveElementSkill>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.disabledSkills.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.elementId);
		writer.writeInt(this.elementTypeId);
		writer.writeUShort(this.enabledSkills.size());
		for (InteractiveElementSkill entry : this.enabledSkills)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
		writer.writeUShort(this.disabledSkills.size());
		for (InteractiveElementSkill entry : this.disabledSkills)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}