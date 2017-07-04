package org.michocko.dofus2.protocol.types.game.context.roleplay;

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
public class GameRolePlayMutantInformations extends GameRolePlayHumanoidInformations {
	public static final short TYPE_ID = 3;
	
	private int monsterId;
	private byte powerLevel;
	
	public GameRolePlayMutantInformations() {
	}
	
	public GameRolePlayMutantInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, HumanInformations humanoidInfo, int accountId, int monsterId, byte powerLevel) {
		super(contextualId, look, disposition, name, humanoidInfo, accountId);
		this.monsterId = monsterId;
		this.powerLevel = powerLevel;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.monsterId = reader.readInt();
		this.powerLevel = reader.readSByte();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.monsterId);
		writer.writeSByte(this.powerLevel);
	}
}