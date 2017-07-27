package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GameRolePlayActorInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;
import org.chuckame.dofus2.protocol.types.game.prism.PrismInformation;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameRolePlayPrismInformations extends GameRolePlayActorInformations {
	public static final short TYPE_ID = 161;
	
	private PrismInformation prism;
	
	public GameRolePlayPrismInformations() {
	}
	
	public GameRolePlayPrismInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, PrismInformation prism) {
		super(contextualId, look, disposition);
		this.prism = prism;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.prism = ProtocolTypeManager.getInstance().<PrismInformation>newInstance(reader.readShort());
		this.prism.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.prism.getProtocolTypeId());
		this.prism.serialize(writer);
	}
}