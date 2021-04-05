package org.michocko.dofus2.protocol.messages.game.context;

import org.michocko.dofus2.protocol.types.game.context.IdentifiedEntityDispositionInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameEntityDispositionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5693;
	
	private IdentifiedEntityDispositionInformations disposition;
	
	public GameEntityDispositionMessage() {
	}
	
	public GameEntityDispositionMessage(IdentifiedEntityDispositionInformations disposition) {
		this.disposition = disposition;
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
		this.disposition = new IdentifiedEntityDispositionInformations();
		this.disposition.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.disposition.serialize(writer);
	}
}