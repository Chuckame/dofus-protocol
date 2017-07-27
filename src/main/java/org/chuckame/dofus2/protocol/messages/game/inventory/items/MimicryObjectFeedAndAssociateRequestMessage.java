package org.chuckame.dofus2.protocol.messages.game.inventory.items;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MimicryObjectFeedAndAssociateRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6460;
	
	private int mimicryUID;
	private short mimicryPos;
	private int foodUID;
	private short foodPos;
	private int hostUID;
	private short hostPos;
	private boolean preview;
	
	public MimicryObjectFeedAndAssociateRequestMessage() {
	}
	
	public MimicryObjectFeedAndAssociateRequestMessage(int mimicryUID, short mimicryPos, int foodUID, short foodPos, int hostUID, short hostPos, boolean preview) {
		this.mimicryUID = mimicryUID;
		this.mimicryPos = mimicryPos;
		this.foodUID = foodUID;
		this.foodPos = foodPos;
		this.hostUID = hostUID;
		this.hostPos = hostPos;
		this.preview = preview;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mimicryUID = reader.readInt();
		if (mimicryUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on mimicryUID = %s, it doesn't respect the following condition : mimicryUID < 0", mimicryUID));
		this.mimicryPos = reader.readByte();
		if (mimicryPos < 0 || mimicryPos > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on mimicryPos = %s, it doesn't respect the following condition : mimicryPos < 0 || mimicryPos > 255", mimicryPos));
		this.foodUID = reader.readInt();
		if (foodUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on foodUID = %s, it doesn't respect the following condition : foodUID < 0", foodUID));
		this.foodPos = reader.readByte();
		if (foodPos < 0 || foodPos > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on foodPos = %s, it doesn't respect the following condition : foodPos < 0 || foodPos > 255", foodPos));
		this.hostUID = reader.readInt();
		if (hostUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on hostUID = %s, it doesn't respect the following condition : hostUID < 0", hostUID));
		this.hostPos = reader.readByte();
		if (hostPos < 0 || hostPos > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on hostPos = %s, it doesn't respect the following condition : hostPos < 0 || hostPos > 255", hostPos));
		this.preview = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.mimicryUID);
		writer.writeByte(this.mimicryPos);
		writer.writeInt(this.foodUID);
		writer.writeByte(this.foodPos);
		writer.writeInt(this.hostUID);
		writer.writeByte(this.hostPos);
		writer.writeBoolean(this.preview);
	}
}