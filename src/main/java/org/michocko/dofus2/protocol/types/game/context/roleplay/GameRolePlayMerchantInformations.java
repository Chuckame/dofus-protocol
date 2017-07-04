package org.michocko.dofus2.protocol.types.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.HumanOption;
import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.GameRolePlayNamedActorInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameRolePlayMerchantInformations extends GameRolePlayNamedActorInformations {
	public static final short TYPE_ID = 129;
	
	private int sellType;
	private Collection<HumanOption> options;
	
	public GameRolePlayMerchantInformations() {
	}
	
	public GameRolePlayMerchantInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, int sellType, Collection<HumanOption> options) {
		super(contextualId, look, disposition, name);
		this.sellType = sellType;
		this.options = options;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.sellType = reader.readInt();
		if (sellType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on sellType = %s, it doesn't respect the following condition : sellType < 0", sellType));
		int length = reader.readUShort();
		this.options = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			HumanOption entry = ProtocolTypeManager.getInstance().<HumanOption>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.options.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.sellType);
		writer.writeUShort(this.options.size());
		for (HumanOption entry : this.options)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}