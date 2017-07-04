package org.michocko.dofus2.protocol.messages.game.shortcut;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ShortcutBarSwapRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6230;
	
	private byte barType;
	private int firstSlot;
	private int secondSlot;
	
	public ShortcutBarSwapRequestMessage() {
	}
	
	public ShortcutBarSwapRequestMessage(byte barType, int firstSlot, int secondSlot) {
		this.barType = barType;
		this.firstSlot = firstSlot;
		this.secondSlot = secondSlot;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.barType = reader.readSByte();
		if (barType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on barType = %s, it doesn't respect the following condition : barType < 0", barType));
		this.firstSlot = reader.readInt();
		if (firstSlot < 0 || firstSlot > 99)
			throw new IllegalArgumentException(String.format("Forbidden value on firstSlot = %s, it doesn't respect the following condition : firstSlot < 0 || firstSlot > 99", firstSlot));
		this.secondSlot = reader.readInt();
		if (secondSlot < 0 || secondSlot > 99)
			throw new IllegalArgumentException(String.format("Forbidden value on secondSlot = %s, it doesn't respect the following condition : secondSlot < 0 || secondSlot > 99", secondSlot));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.barType);
		writer.writeInt(this.firstSlot);
		writer.writeInt(this.secondSlot);
	}
}