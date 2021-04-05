package org.michocko.dofus2.protocol.types.game.context;

import org.michocko.dofus2.protocol.types.game.context.TaxCollectorStaticInformations;
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
public class GameRolePlayTaxCollectorInformations extends GameRolePlayActorInformations {
	public static final short TYPE_ID = 148;
	
	private TaxCollectorStaticInformations identification;
	private short guildLevel;
	private int taxCollectorAttack;
	
	public GameRolePlayTaxCollectorInformations() {
	}
	
	public GameRolePlayTaxCollectorInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, TaxCollectorStaticInformations identification, short guildLevel, int taxCollectorAttack) {
		super(contextualId, look, disposition);
		this.identification = identification;
		this.guildLevel = guildLevel;
		this.taxCollectorAttack = taxCollectorAttack;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.identification = (TaxCollectorStaticInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
		this.identification.deserialize(reader);
		this.guildLevel = reader.readByte();
		if (guildLevel < 0 || guildLevel > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on guildLevel = %s, it doesn't respect the following condition : guildLevel < 0 || guildLevel > 255", guildLevel));
		this.taxCollectorAttack = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.identification.getNetworkTypeId());
		this.identification.serialize(writer);
		writer.writeByte(this.guildLevel);
		writer.writeInt(this.taxCollectorAttack);
	}
}