package org.chuckame.dofus2.protocol.messages.game.guild.tax;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.taxCollectorId = reader.readInt();
		this.characterId = reader.readInt();
		if (characterId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on characterId = %s, it doesn't respect the following condition : characterId < 0", characterId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.taxCollectorId);
		writer.writeInt(this.characterId);
	}
}