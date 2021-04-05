package org.michocko.dofus2.protocol.messages.game.atlas;

import org.michocko.dofus2.protocol.types.game.context.roleplay.AtlasPointsInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.type = new AtlasPointsInformations();
		this.type.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.type.serialize(writer);
	}
}