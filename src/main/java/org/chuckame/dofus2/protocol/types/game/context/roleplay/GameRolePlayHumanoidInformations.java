package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GameRolePlayNamedActorInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.HumanInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameRolePlayHumanoidInformations extends GameRolePlayNamedActorInformations {
	public static final short TYPE_ID = 159;
	
	private HumanInformations humanoidInfo;
	private int accountId;
	
	public GameRolePlayHumanoidInformations() {
	}
	
	public GameRolePlayHumanoidInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, HumanInformations humanoidInfo, int accountId) {
		super(contextualId, look, disposition, name);
		this.humanoidInfo = humanoidInfo;
		this.accountId = accountId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.humanoidInfo = ProtocolTypeManager.getInstance().<HumanInformations>newInstance(reader.readShort());
		this.humanoidInfo.deserialize(reader);
		this.accountId = reader.readInt();
		if (accountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountId = %s, it doesn't respect the following condition : accountId < 0", accountId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.humanoidInfo.getProtocolTypeId());
		this.humanoidInfo.serialize(writer);
		writer.writeInt(this.accountId);
	}
}