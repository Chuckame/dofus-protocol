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
public class GuildFightLeaveRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5715;
	
	private int taxCollectorId;
	private int characterId;
	
	public GuildFightLeaveRequestMessage() {
	}
	
	public GuildFightLeaveRequestMessage(int taxCollectorId, int characterId) {
		this.taxCollectorId = taxCollectorId;
		this.characterId = characterId;
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
		this.characterId = reader.readInt();
		if (characterId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on characterId = %s, it doesn't respect the following condition : characterId < 0", characterId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.taxCollectorId);
		writer.writeInt(this.characterId);
	}
}