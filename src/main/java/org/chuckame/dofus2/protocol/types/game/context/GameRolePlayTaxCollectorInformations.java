package org.chuckame.dofus2.protocol.types.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.chuckame.dofus2.protocol.types.game.context.TaxCollectorStaticInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GameRolePlayActorInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

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
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.identification = ProtocolTypeManager.getInstance().<TaxCollectorStaticInformations>newInstance(reader.readShort());
		this.identification.deserialize(reader);
		this.guildLevel = reader.readByte();
		if (guildLevel < 0 || guildLevel > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on guildLevel = %s, it doesn't respect the following condition : guildLevel < 0 || guildLevel > 255", guildLevel));
		this.taxCollectorAttack = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.identification.getProtocolTypeId());
		this.identification.serialize(writer);
		writer.writeByte(this.guildLevel);
		writer.writeInt(this.taxCollectorAttack);
	}
}