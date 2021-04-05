package org.michocko.dofus2.protocol.messages.game.alliance;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.AllianceInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.BasicAllianceInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class KohUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6439;
	
	private Collection<AllianceInformations> alliances;
	private Collection<Short> allianceNbMembers;
	private Collection<Integer> allianceRoundWeigth;
	private Collection<Byte> allianceMatchScore;
	private BasicAllianceInformations allianceMapWinner;
	private int allianceMapWinnerScore;
	private int allianceMapMyAllianceScore;
	private double nextTickTime;
	
	public KohUpdateMessage() {
	}
	
	public KohUpdateMessage(Collection<AllianceInformations> alliances, Collection<Short> allianceNbMembers, Collection<Integer> allianceRoundWeigth, Collection<Byte> allianceMatchScore, BasicAllianceInformations allianceMapWinner, int allianceMapWinnerScore, int allianceMapMyAllianceScore, double nextTickTime) {
		this.alliances = alliances;
		this.allianceNbMembers = allianceNbMembers;
		this.allianceRoundWeigth = allianceRoundWeigth;
		this.allianceMatchScore = allianceMatchScore;
		this.allianceMapWinner = allianceMapWinner;
		this.allianceMapWinnerScore = allianceMapWinnerScore;
		this.allianceMapMyAllianceScore = allianceMapMyAllianceScore;
		this.nextTickTime = nextTickTime;
	}
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.alliances = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			AllianceInformations entry = new AllianceInformations();
			entry.deserialize(reader);
			this.alliances.add(entry);
		}
		length = reader.readUShort();
		this.allianceNbMembers = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.allianceNbMembers.add(entry);
		}
		length = reader.readUShort();
		this.allianceRoundWeigth = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.allianceRoundWeigth.add(entry);
		}
		length = reader.readUShort();
		this.allianceMatchScore = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			byte entry = reader.readSByte();
			this.allianceMatchScore.add(entry);
		}
		this.allianceMapWinner = new BasicAllianceInformations();
		this.allianceMapWinner.deserialize(reader);
		this.allianceMapWinnerScore = reader.readInt();
		if (allianceMapWinnerScore < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on allianceMapWinnerScore = %s, it doesn't respect the following condition : allianceMapWinnerScore < 0", allianceMapWinnerScore));
		this.allianceMapMyAllianceScore = reader.readInt();
		if (allianceMapMyAllianceScore < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on allianceMapMyAllianceScore = %s, it doesn't respect the following condition : allianceMapMyAllianceScore < 0", allianceMapMyAllianceScore));
		this.nextTickTime = reader.readDouble();
		if (nextTickTime < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nextTickTime = %s, it doesn't respect the following condition : nextTickTime < 0", nextTickTime));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.alliances.size());
		for (AllianceInformations entry : this.alliances)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.allianceNbMembers.size());
		for (short entry : this.allianceNbMembers)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.allianceRoundWeigth.size());
		for (int entry : this.allianceRoundWeigth)
		{
			writer.writeInt(entry);
		}
		writer.writeUShort(this.allianceMatchScore.size());
		for (byte entry : this.allianceMatchScore)
		{
			writer.writeSByte(entry);
		}
		this.allianceMapWinner.serialize(writer);
		writer.writeInt(this.allianceMapWinnerScore);
		writer.writeInt(this.allianceMapMyAllianceScore);
		writer.writeDouble(this.nextTickTime);
	}
}