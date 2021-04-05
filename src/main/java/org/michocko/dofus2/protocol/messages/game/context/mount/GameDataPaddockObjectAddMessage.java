package org.michocko.dofus2.protocol.messages.game.context.mount;

import org.michocko.dofus2.protocol.types.game.paddock.PaddockItem;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.paddockItemDescription = new PaddockItem();
		this.paddockItemDescription.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.paddockItemDescription.serialize(writer);
	}
}