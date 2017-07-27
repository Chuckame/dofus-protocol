package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GameRolePlayActorInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GroupMonsterStaticInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameRolePlayGroupMonsterInformations extends GameRolePlayActorInformations {
	public static final short TYPE_ID = 160;
	
	private GroupMonsterStaticInformations staticInfos;
	private short ageBonus;
	private byte lootShare;
	private byte alignmentSide;
	
	public GameRolePlayGroupMonsterInformations() {
	}
	
	public GameRolePlayGroupMonsterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, GroupMonsterStaticInformations staticInfos, short ageBonus, byte lootShare, byte alignmentSide) {
		super(contextualId, look, disposition);
		this.staticInfos = staticInfos;
		this.ageBonus = ageBonus;
		this.lootShare = lootShare;
		this.alignmentSide = alignmentSide;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.staticInfos = ProtocolTypeManager.getInstance().<GroupMonsterStaticInformations>newInstance(reader.readShort());
		this.staticInfos.deserialize(reader);
		this.ageBonus = reader.readShort();
		if (ageBonus < -1 || ageBonus > 1000)
			throw new IllegalArgumentException(String.format("Forbidden value on ageBonus = %s, it doesn't respect the following condition : ageBonus < -1 || ageBonus > 1000", ageBonus));
		this.lootShare = reader.readSByte();
		if (lootShare < -1 || lootShare > 8)
			throw new IllegalArgumentException(String.format("Forbidden value on lootShare = %s, it doesn't respect the following condition : lootShare < -1 || lootShare > 8", lootShare));
		this.alignmentSide = reader.readSByte();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.staticInfos.getProtocolTypeId());
		this.staticInfos.serialize(writer);
		writer.writeShort(this.ageBonus);
		writer.writeSByte(this.lootShare);
		writer.writeSByte(this.alignmentSide);
	}
}