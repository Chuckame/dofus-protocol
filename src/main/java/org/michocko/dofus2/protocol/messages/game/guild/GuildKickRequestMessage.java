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
public class GuildKickRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5887;
	
	private int kickedId;
	
	public GuildKickRequestMessage() {
	}
	
	public GuildKickRequestMessage(int kickedId) {
		this.kickedId = kickedId;
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
		this.kickedId = reader.readInt();
		if (kickedId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on kickedId = %s, it doesn't respect the following condition : kickedId < 0", kickedId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.kickedId);
	}
}