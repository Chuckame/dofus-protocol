package org.chuckame.dofus2.protocol.messages.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameContextRefreshEntityLookMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5637;
	
	private int id;
	private EntityLook look;
	
	public GameContextRefreshEntityLookMessage() {
	}
	
	public GameContextRefreshEntityLookMessage(int id, EntityLook look) {
		this.id = id;
		this.look = look;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
		this.look = new EntityLook();
		this.look.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
		this.look.serialize(writer);
	}
}