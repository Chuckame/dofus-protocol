package org.michocko.dofus2.protocol.types.game.social;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class AllianceVersatileInformations implements INetworkType {
	public static final short TYPE_ID = 432;
	
	private int allianceId;
	private short nbGuilds;
	private short nbMembers;
	private short nbSubarea;
	
	public AllianceVersatileInformations() {
	}
	
	public AllianceVersatileInformations(int allianceId, short nbGuilds, short nbMembers, short nbSubarea) {
		this.allianceId = allianceId;
		this.nbGuilds = nbGuilds;
		this.nbMembers = nbMembers;
		this.nbSubarea = nbSubarea;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.allianceId = reader.readInt();
		if (allianceId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on allianceId = %s, it doesn't respect the following condition : allianceId < 0", allianceId));
		this.nbGuilds = reader.readShort();
		if (nbGuilds < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbGuilds = %s, it doesn't respect the following condition : nbGuilds < 0", nbGuilds));
		this.nbMembers = reader.readShort();
		if (nbMembers < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbMembers = %s, it doesn't respect the following condition : nbMembers < 0", nbMembers));
		this.nbSubarea = reader.readShort();
		if (nbSubarea < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbSubarea = %s, it doesn't respect the following condition : nbSubarea < 0", nbSubarea));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.allianceId);
		writer.writeShort(this.nbGuilds);
		writer.writeShort(this.nbMembers);
		writer.writeShort(this.nbSubarea);
	}
}