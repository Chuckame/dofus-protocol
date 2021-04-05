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
		this.accountId = reader.readInt();
		if (accountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountId = %s, it doesn't respect the following condition : accountId < 0", accountId));
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		this.status = (PlayerStatus) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
		this.status.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.accountId);
		writer.writeInt(this.playerId);
		writer.writeShort(this.status.getNetworkTypeId());
		this.status.serialize(writer);
	}
}