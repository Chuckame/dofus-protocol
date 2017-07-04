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
public class PortalDialogQuestionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6495;
	
	private int availableUseLeft;
	private int closeDate;
	
	public PortalDialogQuestionMessage() {
	}
	
	public PortalDialogQuestionMessage(int availableUseLeft, int closeDate) {
		this.availableUseLeft = availableUseLeft;
		this.closeDate = closeDate;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.availableUseLeft = reader.readInt();
		if (availableUseLeft < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on availableUseLeft = %s, it doesn't respect the following condition : availableUseLeft < 0", availableUseLeft));
		this.closeDate = reader.readInt();
		if (closeDate < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on closeDate = %s, it doesn't respect the following condition : closeDate < 0", closeDate));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.availableUseLeft);
		writer.writeInt(this.closeDate);
	}
}