package org.chuckame.dofus2.protocol.types.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightOptionsInformations;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightTeamLightInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class FightExternalInformations implements INetworkType {
	public static final short TYPE_ID = 117;
	
	private int fightId;
	private byte fightType;
	private int fightStart;
	private boolean fightSpectatorLocked;
	private Collection<FightTeamLightInformations> fightTeams;
	private Collection<FightOptionsInformations> fightTeamsOptions;
	
	public FightExternalInformations() {
	}
	
	public FightExternalInformations(int fightId, byte fightType, int fightStart, boolean fightSpectatorLocked, Collection<FightTeamLightInformations> fightTeams, Collection<FightOptionsInformations> fightTeamsOptions) {
		this.fightId = fightId;
		this.fightType = fightType;
		this.fightStart = fightStart;
		this.fightSpectatorLocked = fightSpectatorLocked;
		this.fightTeams = fightTeams;
		this.fightTeamsOptions = fightTeamsOptions;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightId = reader.readInt();
		this.fightType = reader.readSByte();
		if (fightType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightType = %s, it doesn't respect the following condition : fightType < 0", fightType));
		this.fightStart = reader.readInt();
		if (fightStart < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightStart = %s, it doesn't respect the following condition : fightStart < 0", fightStart));
		this.fightSpectatorLocked = reader.readBoolean();
		int length = reader.readUShort();
		this.fightTeams = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			FightTeamLightInformations entry = new FightTeamLightInformations();
			entry.deserialize(reader);
			this.fightTeams.add(entry);
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
		writer.writeInt(this.fightStart);
		writer.writeBoolean(this.fightSpectatorLocked);
		writer.writeUShort(this.fightTeams.size());
		for (FightTeamLightInformations entry : this.fightTeams)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.fightTeamsOptions.size());
		for (FightOptionsInformations entry : this.fightTeamsOptions)
		{
			entry.serialize(writer);
		}
	}
}