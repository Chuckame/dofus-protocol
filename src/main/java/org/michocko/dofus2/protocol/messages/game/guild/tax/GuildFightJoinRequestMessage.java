package org.michocko.dofus2.protocol.messages.game.guild.tax;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildFightJoinRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5717;
	
	private int taxCollectorId;
	
	public GuildFightJoinRequestMessage() {
	}
	
	public GuildFightJoinRequestMessage(int taxCollectorId) {
		this.taxCollectorId = taxCollectorId;
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
		this.taxCollectorId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.taxCollectorId);
	}
}