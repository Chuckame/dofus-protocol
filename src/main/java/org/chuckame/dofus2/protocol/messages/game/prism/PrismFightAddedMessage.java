package org.chuckame.dofus2.protocol.messages.game.prism;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.prism.PrismFightersInformation;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PrismFightAddedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6452;
	
	private PrismFightersInformation fight;
	
	public PrismFightAddedMessage() {
	}
	
	public PrismFightAddedMessage(PrismFightersInformation fight) {
		this.fight = fight;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fight = new PrismFightersInformation();
		this.fight.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.fight.serialize(writer);
	}
}