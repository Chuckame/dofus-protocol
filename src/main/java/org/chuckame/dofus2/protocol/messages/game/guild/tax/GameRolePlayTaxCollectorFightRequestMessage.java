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
public class GameRolePlayTaxCollectorFightRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5954;
	
	private int taxCollectorId;
	
	public GameRolePlayTaxCollectorFightRequestMessage() {
	}
	
	public GameRolePlayTaxCollectorFightRequestMessage(int taxCollectorId) {
		this.taxCollectorId = taxCollectorId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.taxCollectorId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.taxCollectorId);
	}
}