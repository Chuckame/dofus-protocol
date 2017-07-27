package org.chuckame.dofus2.protocol.types.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class GameFightSpellCooldown implements INetworkType {
	public static final short TYPE_ID = 205;
	
	private int spellId;
	private byte cooldown;
	
	public GameFightSpellCooldown() {
	}
	
	public GameFightSpellCooldown(int spellId, byte cooldown) {
		this.spellId = spellId;
		this.cooldown = cooldown;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.spellId = reader.readInt();
		this.cooldown = reader.readSByte();
		if (cooldown < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on cooldown = %s, it doesn't respect the following condition : cooldown < 0", cooldown));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.spellId);
		writer.writeSByte(this.cooldown);
	}
}