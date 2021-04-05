package org.michocko.dofus2.protocol.messages.game.inventory.items;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class LivingObjectDissociateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5723;
	
	private int livingUID;
	private short livingPosition;
	
	public LivingObjectDissociateMessage() {
	}
	
	public LivingObjectDissociateMessage(int livingUID, short livingPosition) {
		this.livingUID = livingUID;
		this.livingPosition = livingPosition;
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
		this.livingUID = reader.readInt();
		if (livingUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on livingUID = %s, it doesn't respect the following condition : livingUID < 0", livingUID));
		this.livingPosition = reader.readByte();
		if (livingPosition < 0 || livingPosition > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on livingPosition = %s, it doesn't respect the following condition : livingPosition < 0 || livingPosition > 255", livingPosition));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.livingUID);
		writer.writeByte(this.livingPosition);
	}
}