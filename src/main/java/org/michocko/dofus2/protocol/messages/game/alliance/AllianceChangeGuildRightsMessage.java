package org.michocko.dofus2.protocol.messages.game.alliance;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AllianceChangeGuildRightsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6426;
	
	private int guildId;
	private byte rights;
	
	public AllianceChangeGuildRightsMessage() {
	}
	
	public AllianceChangeGuildRightsMessage(int guildId, byte rights) {
		this.guildId = guildId;
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
		this.guildId = reader.readInt();
		if (guildId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on guildId = %s, it doesn't respect the following condition : guildId < 0", guildId));
		this.rights = reader.readSByte();
		if (rights < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on rights = %s, it doesn't respect the following condition : rights < 0", rights));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.guildId);
		writer.writeSByte(this.rights);
	}
}