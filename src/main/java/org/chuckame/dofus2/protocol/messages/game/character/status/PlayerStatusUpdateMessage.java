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
public class PlayerStatusUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6386;
	
	private int accountId;
	private int playerId;
	private PlayerStatus status;
	
	public PlayerStatusUpdateMessage() {
	}
	
	public PlayerStatusUpdateMessage(int accountId, int playerId, PlayerStatus status) {
		this.accountId = accountId;
		this.playerId = playerId;
		this.status = status;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.accountId = reader.readInt();
		if (accountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountId = %s, it doesn't respect the following condition : accountId < 0", accountId));
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		this.status = ProtocolTypeManager.getInstance().<PlayerStatus>newInstance(reader.readShort());
		this.status.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.accountId);
		writer.writeInt(this.playerId);
		writer.writeShort(this.status.getProtocolTypeId());
		this.status.serialize(writer);
	}
}