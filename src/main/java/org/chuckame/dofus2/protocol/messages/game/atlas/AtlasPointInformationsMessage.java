package org.chuckame.dofus2.protocol.messages.game.atlas;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.AtlasPointsInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AtlasPointInformationsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5956;
	
	private AtlasPointsInformations type;
	
	public AtlasPointInformationsMessage() {
	}
	
	public AtlasPointInformationsMessage(AtlasPointsInformations type) {
		this.type = type;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.type = new AtlasPointsInformations();
		this.type.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.type.serialize(writer);
	}
}