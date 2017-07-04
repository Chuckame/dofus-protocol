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
public class GameRolePlayTaxCollectorFightRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5954;
	
	private int taxCollectorId;
	
	public GameRolePlayTaxCollectorFightRequestMessage() {
	}
	
	public GameRolePlayTaxCollectorFightRequestMessage(int taxCollectorId) {
		this.taxCollectorId = taxCollectorId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.taxCollectorId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.taxCollectorId);
	}
}