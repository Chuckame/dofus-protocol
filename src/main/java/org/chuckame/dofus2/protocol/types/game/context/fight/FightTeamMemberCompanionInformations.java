package org.chuckame.dofus2.protocol.types.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightTeamMemberInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightTeamMemberCompanionInformations extends FightTeamMemberInformations {
	public static final short TYPE_ID = 451;
	
	private int companionId;
	private short level;
	private int masterId;
	
	public FightTeamMemberCompanionInformations() {
	}
	
	public FightTeamMemberCompanionInformations(int id, int companionId, short level, int masterId) {
		super(id);
		this.companionId = companionId;
		this.level = level;
		this.masterId = masterId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.companionId = reader.readInt();
		this.level = reader.readShort();
		if (level < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0", level));
		this.masterId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.companionId);
		writer.writeShort(this.level);
		writer.writeInt(this.masterId);
	}
}