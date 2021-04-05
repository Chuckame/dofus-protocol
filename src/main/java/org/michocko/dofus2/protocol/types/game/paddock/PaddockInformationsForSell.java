package org.michocko.dofus2.protocol.types.game.paddock;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class PaddockInformationsForSell implements INetworkType {
	public static final short TYPE_ID = 222;
	
	private String guildOwner;
	private short worldX;
	private short worldY;
	private short subAreaId;
	private byte nbMount;
	private byte nbObject;
	private int price;
	
	public PaddockInformationsForSell() {
	}
	
	public PaddockInformationsForSell(String guildOwner, short worldX, short worldY, short subAreaId, byte nbMount, byte nbObject, int price) {
		this.guildOwner = guildOwner;
		this.worldX = worldX;
		this.worldY = worldY;
		this.subAreaId = subAreaId;
		this.nbMount = nbMount;
		this.nbObject = nbObject;
		this.price = price;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.guildOwner = reader.readUTF();
		this.worldX = reader.readShort();
		if (worldX < -255 || worldX > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldX = %s, it doesn't respect the following condition : worldX < -255 || worldX > 255", worldX));
		this.worldY = reader.readShort();
		if (worldY < -255 || worldY > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldY = %s, it doesn't respect the following condition : worldY < -255 || worldY > 255", worldY));
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.nbMount = reader.readSByte();
		this.nbObject = reader.readSByte();
		this.price = reader.readInt();
		if (price < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on price = %s, it doesn't respect the following condition : price < 0", price));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.guildOwner);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeShort(this.subAreaId);
		writer.writeSByte(this.nbMount);
		writer.writeSByte(this.nbObject);
		writer.writeInt(this.price);
	}
}