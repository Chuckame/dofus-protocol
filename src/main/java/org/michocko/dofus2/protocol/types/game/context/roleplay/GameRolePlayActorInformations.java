package org.michocko.dofus2.protocol.types.game.context.roleplay;

import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.michocko.dofus2.protocol.types.game.context.GameContextActorInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameRolePlayActorInformations extends GameContextActorInformations {
	public static final short TYPE_ID = 141;
	
	
	public GameRolePlayActorInformations() {
	}
	
	public GameRolePlayActorInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition) {
		super(contextualId, look, disposition);
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}