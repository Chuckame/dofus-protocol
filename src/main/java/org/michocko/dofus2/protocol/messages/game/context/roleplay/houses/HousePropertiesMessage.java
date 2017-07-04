package org.michocko.dofus2.protocol.messages.game.context.roleplay.houses;

import org.michocko.dofus2.protocol.types.game.house.HouseInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class HousePropertiesMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5734;
	
	private HouseInformations properties;
	
	public HousePropertiesMessage() {
	}
	
	public HousePropertiesMessage(HouseInformations properties) {
		this.properties = properties;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.properties = ProtocolTypeManager.getInstance().<HouseInformations>newInstance(reader.readShort());
		this.properties.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.properties.getNetworkTypeId());
		this.properties.serialize(writer);
	}
}