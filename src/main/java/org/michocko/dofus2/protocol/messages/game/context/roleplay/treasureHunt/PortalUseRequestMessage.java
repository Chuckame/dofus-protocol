package org.michocko.dofus2.protocol.messages.game.context.roleplay.treasureHunt;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.portalId = reader.readInt();
		if (portalId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on portalId = %s, it doesn't respect the following condition : portalId < 0", portalId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.portalId);
	}
}