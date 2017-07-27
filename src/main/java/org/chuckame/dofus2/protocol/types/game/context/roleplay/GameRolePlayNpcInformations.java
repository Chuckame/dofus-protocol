package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GameRolePlayActorInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameRolePlayNpcInformations extends GameRolePlayActorInformations {
	public static final short TYPE_ID = 156;
	
	private short npcId;
	private boolean sex;
	private short specialArtworkId;
	
	public GameRolePlayNpcInformations() {
	}
	
	public GameRolePlayNpcInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, short npcId, boolean sex, short specialArtworkId) {
		super(contextualId, look, disposition);
		this.npcId = npcId;
		this.sex = sex;
		this.specialArtworkId = specialArtworkId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.npcId = reader.readShort();
		if (npcId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on npcId = %s, it doesn't respect the following condition : npcId < 0", npcId));
		this.sex = reader.readBoolean();
		this.specialArtworkId = reader.readShort();
		if (specialArtworkId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on specialArtworkId = %s, it doesn't respect the following condition : specialArtworkId < 0", specialArtworkId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.npcId);
		writer.writeBoolean(this.sex);
		writer.writeShort(this.specialArtworkId);
	}
}