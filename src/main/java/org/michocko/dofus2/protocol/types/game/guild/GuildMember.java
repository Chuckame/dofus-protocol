package org.michocko.dofus2.protocol.types.game.guild;

import org.michocko.dofus2.protocol.types.game.character.status.PlayerStatus;
import org.michocko.dofus2.protocol.types.game.character.CharacterMinimalInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GuildMember extends CharacterMinimalInformations {
	public static final short TYPE_ID = 88;
	
	private byte breed;
	private boolean sex;
	private short rank;
	private double givenExperience;
	private byte experienceGivenPercent;
	private long rights;
	private byte connected;
	private byte alignmentSide;
	private int hoursSinceLastConnection;
	private byte moodSmileyId;
	private int accountId;
	private int achievementPoints;
	private PlayerStatus status;
	
	public GuildMember() {
	}
	
	public GuildMember(int id, short level, String name, byte breed, boolean sex, short rank, double givenExperience, byte experienceGivenPercent, long rights, byte connected, byte alignmentSide, int hoursSinceLastConnection, byte moodSmileyId, int accountId, int achievementPoints, PlayerStatus status) {
		super(id, level, name);
		this.breed = breed;
		this.sex = sex;
		this.rank = rank;
		this.givenExperience = givenExperience;
		this.experienceGivenPercent = experienceGivenPercent;
		this.rights = rights;
		this.connected = connected;
		this.alignmentSide = alignmentSide;
		this.hoursSinceLastConnection = hoursSinceLastConnection;
		this.moodSmileyId = moodSmileyId;
		this.accountId = accountId;
		this.achievementPoints = achievementPoints;
		this.status = status;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.breed = reader.readSByte();
		this.sex = reader.readBoolean();
		this.rank = reader.readShort();
		if (rank < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on rank = %s, it doesn't respect the following condition : rank < 0", rank));
		this.givenExperience = reader.readDouble();
		if (givenExperience < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on givenExperience = %s, it doesn't respect the following condition : givenExperience < 0", givenExperience));
		this.experienceGivenPercent = reader.readSByte();
		if (experienceGivenPercent < 0 || experienceGivenPercent > 100)
			throw new IllegalArgumentException(String.format("Forbidden value on experienceGivenPercent = %s, it doesn't respect the following condition : experienceGivenPercent < 0 || experienceGivenPercent > 100", experienceGivenPercent));
		this.rights = reader.readUInt();
		if (rights < 0 || rights > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on rights = %s, it doesn't respect the following condition : rights < 0 || rights > 4.294967295E9", rights));
		this.connected = reader.readSByte();
		if (connected < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on connected = %s, it doesn't respect the following condition : connected < 0", connected));
		this.alignmentSide = reader.readSByte();
		this.hoursSinceLastConnection = reader.readUShort();
		if (hoursSinceLastConnection < 0 || hoursSinceLastConnection > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on hoursSinceLastConnection = %s, it doesn't respect the following condition : hoursSinceLastConnection < 0 || hoursSinceLastConnection > 65535", hoursSinceLastConnection));
		this.moodSmileyId = reader.readSByte();
		this.accountId = reader.readInt();
		if (accountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountId = %s, it doesn't respect the following condition : accountId < 0", accountId));
		this.achievementPoints = reader.readInt();
		this.status = (PlayerStatus) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
		this.status.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.breed);
		writer.writeBoolean(this.sex);
		writer.writeShort(this.rank);
		writer.writeDouble(this.givenExperience);
		writer.writeSByte(this.experienceGivenPercent);
		writer.writeUInt(this.rights);
		writer.writeSByte(this.connected);
		writer.writeSByte(this.alignmentSide);
		writer.writeUShort(this.hoursSinceLastConnection);
		writer.writeSByte(this.moodSmileyId);
		writer.writeInt(this.accountId);
		writer.writeInt(this.achievementPoints);
		writer.writeShort(this.status.getNetworkTypeId());
		this.status.serialize(writer);
	}
}