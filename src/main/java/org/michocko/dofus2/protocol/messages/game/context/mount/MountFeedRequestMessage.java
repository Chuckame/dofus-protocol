package org.michocko.dofus2.protocol.messages.game.context.mount;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MountFeedRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6189;
	
	private double mountUid;
	private byte mountLocation;
	private int mountFoodUid;
	private int quantity;
	
	public MountFeedRequestMessage() {
	}
	
	public MountFeedRequestMessage(double mountUid, byte mountLocation, int mountFoodUid, int quantity) {
		this.mountUid = mountUid;
		this.mountLocation = mountLocation;
		this.mountFoodUid = mountFoodUid;
		this.quantity = quantity;
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
		this.mountUid = reader.readDouble();
		if (mountUid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on mountUid = %s, it doesn't respect the following condition : mountUid < 0", mountUid));
		this.mountLocation = reader.readSByte();
		this.mountFoodUid = reader.readInt();
		if (mountFoodUid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on mountFoodUid = %s, it doesn't respect the following condition : mountFoodUid < 0", mountFoodUid));
		this.quantity = reader.readInt();
		if (quantity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on quantity = %s, it doesn't respect the following condition : quantity < 0", quantity));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.mountUid);
		writer.writeSByte(this.mountLocation);
		writer.writeInt(this.mountFoodUid);
		writer.writeInt(this.quantity);
	}
}