package org.michocko.dofus2.protocol.types.game.context.roleplay;

import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.GameRolePlayNamedActorInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameRolePlayMountInformations extends GameRolePlayNamedActorInformations {
	public static final short TYPE_ID = 180;
	
	private String ownerName;
	private short level;
	
	public GameRolePlayMountInformations() {
	}
	
	public GameRolePlayMountInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, String ownerName, short level) {
		super(contextualId, look, disposition, name);
		this.ownerName = ownerName;
		this.level = level;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.ownerName = reader.readUTF();
		this.level = reader.readByte();
		if (level < 0 || level > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0 || level > 255", level));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.ownerName);
		writer.writeByte(this.level);
	}
}