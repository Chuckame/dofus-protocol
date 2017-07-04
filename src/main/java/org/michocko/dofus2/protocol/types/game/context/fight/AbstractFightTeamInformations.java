package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class AbstractFightTeamInformations implements INetworkType {
	public static final short TYPE_ID = 116;
	
	private byte teamId;
	private int leaderId;
	private byte teamSide;
	private byte teamTypeId;
	private long nbWaves;
	
	public AbstractFightTeamInformations() {
	}
	
	public AbstractFightTeamInformations(byte teamId, int leaderId, byte teamSide, byte teamTypeId, long nbWaves) {
		this.teamId = teamId;
		this.leaderId = leaderId;
		this.teamSide = teamSide;
		this.teamTypeId = teamTypeId;
		this.nbWaves = nbWaves;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.teamId = reader.readSByte();
		if (teamId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on teamId = %s, it doesn't respect the following condition : teamId < 0", teamId));
		this.leaderId = reader.readInt();
		this.teamSide = reader.readSByte();
		this.teamTypeId = reader.readSByte();
		if (teamTypeId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on teamTypeId = %s, it doesn't respect the following condition : teamTypeId < 0", teamTypeId));
		this.nbWaves = reader.readUInt();
		if (nbWaves < 0 || nbWaves > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on nbWaves = %s, it doesn't respect the following condition : nbWaves < 0 || nbWaves > 4.294967295E9", nbWaves));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.teamId);
		writer.writeInt(this.leaderId);
		writer.writeSByte(this.teamSide);
		writer.writeSByte(this.teamTypeId);
		writer.writeUInt(this.nbWaves);
	}
}