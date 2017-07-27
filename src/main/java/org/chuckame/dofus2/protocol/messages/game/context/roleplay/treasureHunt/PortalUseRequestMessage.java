package org.chuckame.dofus2.protocol.messages.game.context.roleplay.treasureHunt;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PortalUseRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6492;
	
	private int portalId;
	
	public PortalUseRequestMessage() {
	}
	
	public PortalUseRequestMessage(int portalId) {
		this.portalId = portalId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.portalId = reader.readInt();
		if (portalId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on portalId = %s, it doesn't respect the following condition : portalId < 0", portalId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.portalId);
	}
}