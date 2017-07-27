package org.chuckame.dofus2.protocol.messages.game.character.status;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.character.status.PlayerStatus;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PlayerStatusUpdateRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6387;
	
	private PlayerStatus status;
	
	public PlayerStatusUpdateRequestMessage() {
	}
	
	public PlayerStatusUpdateRequestMessage(PlayerStatus status) {
		this.status = status;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.status = ProtocolTypeManager.getInstance().<PlayerStatus>newInstance(reader.readShort());
		this.status.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.status.getProtocolTypeId());
		this.status.serialize(writer);
	}
}