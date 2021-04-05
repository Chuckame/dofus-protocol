package org.michocko.dofus2.protocol.messages.game.context;

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
		this.id = reader.readInt();
		this.look = new EntityLook();
		this.look.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
		this.look.serialize(writer);
	}
}