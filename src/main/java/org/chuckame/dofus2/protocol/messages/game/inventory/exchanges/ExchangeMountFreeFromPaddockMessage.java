package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeMountFreeFromPaddockMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6055;
	
	private String name;
	private short worldX;
	private short worldY;
	private String liberator;
	
	public ExchangeMountFreeFromPaddockMessage() {
	}
	
	public ExchangeMountFreeFromPaddockMessage(String name, short worldX, short worldY, String liberator) {
		this.name = name;
		this.worldX = worldX;
		this.worldY = worldY;
		this.liberator = liberator;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.name = reader.readUTF();
		this.worldX = reader.readShort();
		if (worldX < -255 || worldX > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldX = %s, it doesn't respect the following condition : worldX < -255 || worldX > 255", worldX));
		this.worldY = reader.readShort();
		if (worldY < -255 || worldY > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldY = %s, it doesn't respect the following condition : worldY < -255 || worldY > 255", worldY));
		this.liberator = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.name);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeUTF(this.liberator);
	}
}