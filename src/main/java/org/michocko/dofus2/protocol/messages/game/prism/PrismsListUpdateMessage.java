package org.michocko.dofus2.protocol.messages.game.prism;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.prism.PrismSubareaEmptyInfo;
import org.michocko.dofus2.protocol.messages.game.prism.PrismsListMessage;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PrismsListUpdateMessage extends PrismsListMessage {
	public static final int MESSAGE_ID = 6438;
	
	
	public PrismsListUpdateMessage() {
	}
	
	public PrismsListUpdateMessage(Collection<PrismSubareaEmptyInfo> prisms) {
		super(prisms);
	}
	
	@Override
	public int getNetworkMessageId() {
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