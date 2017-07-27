package org.chuckame.dofus2.protocol.messages.game.guild.tax;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.guild.tax.TaxCollectorInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TaxCollectorMovementAddMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5917;
	
	private TaxCollectorInformations informations;
	
	public TaxCollectorMovementAddMessage() {
	}
	
	public TaxCollectorMovementAddMessage(TaxCollectorInformations informations) {
		this.informations = informations;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.informations = ProtocolTypeManager.getInstance().<TaxCollectorInformations>newInstance(reader.readShort());
		this.informations.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.informations.getProtocolTypeId());
		this.informations.serialize(writer);
	}
}