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
public class FightTeamMemberInformations implements INetworkType {
	public static final short TYPE_ID = 44;
	
	private int id;
	
	public FightTeamMemberInformations() {
	}
	
	public FightTeamMemberInformations(int id) {
		this.id = id;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
	}
}