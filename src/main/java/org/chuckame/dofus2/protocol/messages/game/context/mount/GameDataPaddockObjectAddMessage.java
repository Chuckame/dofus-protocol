package org.chuckame.dofus2.protocol.messages.game.context.mount;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.paddock.PaddockItem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameDataPaddockObjectAddMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5990;
	
	private PaddockItem paddockItemDescription;
	
	public GameDataPaddockObjectAddMessage() {
	}
	
	public GameDataPaddockObjectAddMessage(PaddockItem paddockItemDescription) {
		this.paddockItemDescription = paddockItemDescription;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.paddockItemDescription = new PaddockItem();
		this.paddockItemDescription.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.paddockItemDescription.serialize(writer);
	}
}