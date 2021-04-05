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
public class GuildChangeMemberParametersMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5549;
	
	private int memberId;
	private short rank;
	private byte experienceGivenPercent;
	private long rights;
	
	public GuildChangeMemberParametersMessage() {
	}
	
	public GuildChangeMemberParametersMessage(int memberId, short rank, byte experienceGivenPercent, long rights) {
		this.memberId = memberId;
		this.rank = rank;
		this.experienceGivenPercent = experienceGivenPercent;
		this.rights = rights;
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
		this.memberId = reader.readInt();
		if (memberId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on memberId = %s, it doesn't respect the following condition : memberId < 0", memberId));
		this.rank = reader.readShort();
		if (rank < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on rank = %s, it doesn't respect the following condition : rank < 0", rank));
		this.experienceGivenPercent = reader.readSByte();
		if (experienceGivenPercent < 0 || experienceGivenPercent > 100)
			throw new IllegalArgumentException(String.format("Forbidden value on experienceGivenPercent = %s, it doesn't respect the following condition : experienceGivenPercent < 0 || experienceGivenPercent > 100", experienceGivenPercent));
		this.rights = reader.readUInt();
		if (rights < 0 || rights > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on rights = %s, it doesn't respect the following condition : rights < 0 || rights > 4.294967295E9", rights));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.memberId);
		writer.writeShort(this.rank);
		writer.writeSByte(this.experienceGivenPercent);
		writer.writeUInt(this.rights);
	}
}