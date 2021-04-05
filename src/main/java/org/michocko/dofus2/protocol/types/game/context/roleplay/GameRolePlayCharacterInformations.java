package org.michocko.dofus2.protocol.types.game.context.roleplay;

import org.michocko.dofus2.protocol.types.game.character.alignment.ActorAlignmentInformations;
import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.HumanInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.GameRolePlayHumanoidInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameRolePlayCharacterInformations extends GameRolePlayHumanoidInformations {
	public static final short TYPE_ID = 36;
	
	private ActorAlignmentInformations alignmentInfos;
	
	public GameRolePlayCharacterInformations() {
	}
	
	public GameRolePlayCharacterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, HumanInformations humanoidInfo, int accountId, ActorAlignmentInformations alignmentInfos) {
		super(contextualId, look, disposition, name, humanoidInfo, accountId);
		this.alignmentInfos = alignmentInfos;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.alignmentInfos = new ActorAlignmentInformations();
		this.alignmentInfos.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.alignmentInfos.serialize(writer);
	}
}