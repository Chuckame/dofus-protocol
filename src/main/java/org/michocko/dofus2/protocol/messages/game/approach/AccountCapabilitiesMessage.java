package org.michocko.dofus2.protocol.messages.game.approach;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AccountCapabilitiesMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6216;
	
	private int accountId;
	private boolean tutorialAvailable;
	private short breedsVisible;
	private short breedsAvailable;
	private byte status;
	
	public AccountCapabilitiesMessage() {
	}
	
	public AccountCapabilitiesMessage(int accountId, boolean tutorialAvailable, short breedsVisible, short breedsAvailable, byte status) {
		this.accountId = accountId;
		this.tutorialAvailable = tutorialAvailable;
		this.breedsVisible = breedsVisible;
		this.breedsAvailable = breedsAvailable;
		this.status = status;
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
		this.accountId = reader.readInt();
		this.tutorialAvailable = reader.readBoolean();
		this.breedsVisible = reader.readShort();
		if (breedsVisible < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on breedsVisible = %s, it doesn't respect the following condition : breedsVisible < 0", breedsVisible));
		this.breedsAvailable = reader.readShort();
		if (breedsAvailable < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on breedsAvailable = %s, it doesn't respect the following condition : breedsAvailable < 0", breedsAvailable));
		this.status = reader.readSByte();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.accountId);
		writer.writeBoolean(this.tutorialAvailable);
		writer.writeShort(this.breedsVisible);
		writer.writeShort(this.breedsAvailable);
		writer.writeSByte(this.status);
	}
}