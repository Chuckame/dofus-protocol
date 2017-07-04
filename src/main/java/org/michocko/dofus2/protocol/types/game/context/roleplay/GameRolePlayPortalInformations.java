package org.michocko.dofus2.protocol.types.game.context.roleplay;

import org.michocko.dofus2.protocol.types.game.context.roleplay.treasureHunt.PortalInformation;
import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.GameRolePlayActorInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameRolePlayPortalInformations extends GameRolePlayActorInformations {
	public static final short TYPE_ID = 467;
	
	private PortalInformation portal;
	
	public GameRolePlayPortalInformations() {
	}
	
	public GameRolePlayPortalInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, PortalInformation portal) {
		super(contextualId, look, disposition);
		this.portal = portal;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.portal = ProtocolTypeManager.getInstance().<PortalInformation>newInstance(reader.readShort());
		this.portal.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.portal.getNetworkTypeId());
		this.portal.serialize(writer);
	}
}