package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeBidHouseSearchMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5806;
	
	private int type;
	private int genId;
	
	public ExchangeBidHouseSearchMessage() {
	}
	
	public ExchangeBidHouseSearchMessage(int type, int genId) {
		this.type = type;
		this.genId = genId;
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
		this.type = reader.readInt();
		if (type < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on type = %s, it doesn't respect the following condition : type < 0", type));
		this.genId = reader.readInt();
		if (genId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on genId = %s, it doesn't respect the following condition : genId < 0", genId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.type);
		writer.writeInt(this.genId);
	}
}