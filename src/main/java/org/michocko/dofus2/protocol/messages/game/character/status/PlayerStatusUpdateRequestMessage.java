package org.michocko.dofus2.protocol.messages.game.character.status;

import org.michocko.dofus2.protocol.types.game.character.status.PlayerStatus;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.status = ProtocolTypeManager.getInstance().<PlayerStatus>newInstance(reader.readShort());
		this.status.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.status.getNetworkTypeId());
		this.status.serialize(writer);
	}
}