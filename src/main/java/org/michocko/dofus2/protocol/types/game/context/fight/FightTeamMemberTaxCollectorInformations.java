package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.context.fight.FightTeamMemberInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightTeamMemberTaxCollectorInformations extends FightTeamMemberInformations {
	public static final short TYPE_ID = 177;
	
	private short firstNameId;
	private short lastNameId;
	private short level;
	private int guildId;
	private int uid;
	
	public FightTeamMemberTaxCollectorInformations() {
	}
	
	public FightTeamMemberTaxCollectorInformations(int id, short firstNameId, short lastNameId, short level, int guildId, int uid) {
		super(id);
		this.firstNameId = firstNameId;
		this.lastNameId = lastNameId;
		this.level = level;
		this.guildId = guildId;
		this.uid = uid;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.firstNameId = reader.readShort();
		if (firstNameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on firstNameId = %s, it doesn't respect the following condition : firstNameId < 0", firstNameId));
		this.lastNameId = reader.readShort();
		if (lastNameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lastNameId = %s, it doesn't respect the following condition : lastNameId < 0", lastNameId));
		this.level = reader.readByte();
		if (level < 1 || level > 200)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 1 || level > 200", level));
		this.guildId = reader.readInt();
		if (guildId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on guildId = %s, it doesn't respect the following condition : guildId < 0", guildId));
		this.uid = reader.readInt();
		if (uid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on uid = %s, it doesn't respect the following condition : uid < 0", uid));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.firstNameId);
		writer.writeShort(this.lastNameId);
		writer.writeByte(this.level);
		writer.writeInt(this.guildId);
		writer.writeInt(this.uid);
	}
}