package org.michocko.dofus2.protocol.messages.game.social;

import org.michocko.dofus2.protocol.types.game.look.EntityLook;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ContactLookMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5934;
	
	private int requestId;
	private String playerName;
	private int playerId;
	private EntityLook look;
	
	public ContactLookMessage() {
	}
	
	public ContactLookMessage(int requestId, String playerName, int playerId, EntityLook look) {
		this.requestId = requestId;
		this.playerName = playerName;
		this.playerId = playerId;
		this.look = look;
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
		this.requestId = reader.readInt();
		if (requestId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on requestId = %s, it doesn't respect the following condition : requestId < 0", requestId));
		this.playerName = reader.readUTF();
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		this.look = new EntityLook();
		this.look.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.requestId);
		writer.writeUTF(this.playerName);
		writer.writeInt(this.playerId);
		this.look.serialize(writer);
	}
}