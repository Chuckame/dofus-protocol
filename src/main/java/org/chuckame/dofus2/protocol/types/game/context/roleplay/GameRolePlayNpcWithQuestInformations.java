package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GameRolePlayNpcInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.quest.GameRolePlayNpcQuestFlag;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameRolePlayNpcWithQuestInformations extends GameRolePlayNpcInformations {
	public static final short TYPE_ID = 383;
	
	private GameRolePlayNpcQuestFlag questFlag;
	
	public GameRolePlayNpcWithQuestInformations() {
	}
	
	public GameRolePlayNpcWithQuestInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, short npcId, boolean sex, short specialArtworkId, GameRolePlayNpcQuestFlag questFlag) {
		super(contextualId, look, disposition, npcId, sex, specialArtworkId);
		this.questFlag = questFlag;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.questFlag = new GameRolePlayNpcQuestFlag();
		this.questFlag.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.questFlag.serialize(writer);
	}
}