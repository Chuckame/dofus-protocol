package org.michocko.dofus2.protocol.types.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.character.restriction.ActorRestrictionsInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.HumanOption;

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
public class HumanInformations implements INetworkType {
	public static final short TYPE_ID = 157;
	
	private ActorRestrictionsInformations restrictions;
	private boolean sex;
	private Collection<HumanOption> options;
	
	public HumanInformations() {
	}
	
	public HumanInformations(ActorRestrictionsInformations restrictions, boolean sex, Collection<HumanOption> options) {
		this.restrictions = restrictions;
		this.sex = sex;
		this.options = options;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.restrictions = new ActorRestrictionsInformations();
		this.restrictions.deserialize(reader);
		this.sex = reader.readBoolean();
		int length = reader.readUShort();
		this.options = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			HumanOption entry = (HumanOption) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
			entry.deserialize(reader);
			this.options.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		this.restrictions.serialize(writer);
		writer.writeBoolean(this.sex);
		writer.writeUShort(this.options.size());
		for (HumanOption entry : this.options)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}