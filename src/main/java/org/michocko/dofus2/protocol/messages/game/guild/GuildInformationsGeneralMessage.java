package org.michocko.dofus2.protocol.messages.game.guild;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildInformationsGeneralMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5557;
	
	private short level;
	private double expLevelFloor;
	private double experience;
	private double expNextLevelFloor;
	private int creationDate;
	private short nbTotalMembers;
	private short nbConnectedMembers;
	
	public GuildInformationsGeneralMessage() {
	}
	
	public GuildInformationsGeneralMessage(short level, double expLevelFloor, double experience, double expNextLevelFloor, int creationDate, short nbTotalMembers, short nbConnectedMembers) {
		this.level = level;
		this.expLevelFloor = expLevelFloor;
		this.experience = experience;
		this.expNextLevelFloor = expNextLevelFloor;
		this.creationDate = creationDate;
		this.nbTotalMembers = nbTotalMembers;
		this.nbConnectedMembers = nbConnectedMembers;
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
		this.level = reader.readByte();
		if (level < 0 || level > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0 || level > 255", level));
		this.expLevelFloor = reader.readDouble();
		if (expLevelFloor < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on expLevelFloor = %s, it doesn't respect the following condition : expLevelFloor < 0", expLevelFloor));
		this.experience = reader.readDouble();
		if (experience < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experience = %s, it doesn't respect the following condition : experience < 0", experience));
		this.expNextLevelFloor = reader.readDouble();
		if (expNextLevelFloor < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on expNextLevelFloor = %s, it doesn't respect the following condition : expNextLevelFloor < 0", expNextLevelFloor));
		this.creationDate = reader.readInt();
		if (creationDate < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on creationDate = %s, it doesn't respect the following condition : creationDate < 0", creationDate));
		this.nbTotalMembers = reader.readShort();
		if (nbTotalMembers < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbTotalMembers = %s, it doesn't respect the following condition : nbTotalMembers < 0", nbTotalMembers));
		this.nbConnectedMembers = reader.readShort();
		if (nbConnectedMembers < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbConnectedMembers = %s, it doesn't respect the following condition : nbConnectedMembers < 0", nbConnectedMembers));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeByte(this.level);
		writer.writeDouble(this.expLevelFloor);
		writer.writeDouble(this.experience);
		writer.writeDouble(this.expNextLevelFloor);
		writer.writeInt(this.creationDate);
		writer.writeShort(this.nbTotalMembers);
		writer.writeShort(this.nbConnectedMembers);
	}
}