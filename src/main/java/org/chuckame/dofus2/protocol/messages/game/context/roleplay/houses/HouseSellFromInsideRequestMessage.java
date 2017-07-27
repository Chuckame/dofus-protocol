package org.chuckame.dofus2.protocol.messages.game.context.roleplay.houses;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.houses.HouseSellRequestMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class HouseSellFromInsideRequestMessage extends HouseSellRequestMessage {
	public static final int MESSAGE_ID = 5884;
	
	
	public HouseSellFromInsideRequestMessage() {
	}
	
	public HouseSellFromInsideRequestMessage(int amount) {
		super(amount);
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}