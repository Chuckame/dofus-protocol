package org.chuckame.dofus2.protocol.messages.game.inventory.items;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.ObjectItem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MimicryObjectPreviewMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6458;
	
	private ObjectItem result;
	
	public MimicryObjectPreviewMessage() {
	}
	
	public MimicryObjectPreviewMessage(ObjectItem result) {
		this.result = result;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.result = new ObjectItem();
		this.result.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.result.serialize(writer);
	}
}