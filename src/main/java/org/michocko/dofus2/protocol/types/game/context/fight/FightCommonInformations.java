package org.michocko.dofus2.protocol.types.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.fight.FightTeamInformations;
import org.michocko.dofus2.protocol.types.game.context.fight.FightOptionsInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class FightCommonInformations implements INetworkType {
	public static final short TYPE_ID = 43;
	
	private int fightId;
	private byte fightType;
	private Collection<FightTeamInformations> fightTeams;
	private Collection<Short> fightTeamsPositions;
	private Collection<FightOptionsInformations> fightTeamsOptions;
	
	public FightCommonInformations() {
	}
	
	public FightCommonInformations(int fightId, byte fightType, Collection<FightTeamInformations> fightTeams, Collection<Short> fightTeamsPositions, Collection<FightOptionsInformations> fightTeamsOptions) {
		this.fightId = fightId;
		this.fightType = fightType;
		this.fightTeams = fightTeams;
		this.fightTeamsPositions = fightTeamsPositions;
		this.fightTeamsOptions = fightTeamsOptions;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightId = reader.readInt();
		this.fightType = reader.readSByte();
		if (fightType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightType = %s, it doesn't respect the following condition : fightType < 0", fightType));
		int length = reader.readUShort();
		this.fightTeams = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			FightTeamInformations entry = ProtocolTypeManager.getInstance().<FightTeamInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.fightTeams.add(entry);
		}
		length = reader.readUShort();
		this.fightTeamsPositions = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.fightTeamsPositions.add(entry);
		}
		length = reader.readUShort();
		this.fightTeamsOptions = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			FightOptionsInformations entry = new FightOptionsInformations();
			entry.deserialize(reader);
			this.fightTeamsOptions.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.fightId);
		writer.writeSByte(this.fightType);
		writer.writeUShort(this.fightTeams.size());
		for (FightTeamInformations entry : this.fightTeams)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
		writer.writeUShort(this.fightTeamsPositions.size());
		for (short entry : this.fightTeamsPositions)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.fightTeamsOptions.size());
		for (FightOptionsInformations entry : this.fightTeamsOptions)
		{
			entry.serialize(writer);
		}
	}
}