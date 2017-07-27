package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.inventory.exchanges.ExchangeMountStableAddMessage;
import org.chuckame.dofus2.protocol.types.game.mount.MountClientData;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeMountStableBornAddMessage extends ExchangeMountStableAddMessage {
	public static final int MESSAGE_ID = 5966;
	
	
	public ExchangeMountStableBornAddMessage() {
	}
	
	public ExchangeMountStableBornAddMessage(MountClientData mountDescription) {
		super(mountDescription);
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