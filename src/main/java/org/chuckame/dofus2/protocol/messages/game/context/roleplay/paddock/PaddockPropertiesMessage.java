package org.chuckame.dofus2.protocol.messages.game.context.roleplay.paddock;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.paddock.PaddockInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PaddockPropertiesMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5824;
	
	private PaddockInformations properties;
	
	public PaddockPropertiesMessage() {
	}
	
	public PaddockPropertiesMessage(PaddockInformations properties) {
		this.properties = properties;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.properties = ProtocolTypeManager.getInstance().<PaddockInformations>newInstance(reader.readShort());
		this.properties.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.properties.getProtocolTypeId());
		this.properties.serialize(writer);
	}
}