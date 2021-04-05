package org.michocko.dofus2.protocol.messages.game.modificator;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AreaFightModificatorUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6493;
	
	private int spellPairId;
	
	public AreaFightModificatorUpdateMessage() {
	}
	
	public AreaFightModificatorUpdateMessage(int spellPairId) {
		this.spellPairId = spellPairId;
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
		this.spellPairId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.spellPairId);
	}
}