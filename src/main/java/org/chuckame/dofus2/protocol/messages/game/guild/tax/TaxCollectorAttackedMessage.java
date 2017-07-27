package org.chuckame.dofus2.protocol.messages.game.guild.tax;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TaxCollectorAttackedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5918;
	
	private short firstNameId;
	private short lastNameId;
	private short worldX;
	private short worldY;
	private int mapId;
	private short subAreaId;
	private BasicGuildInformations guild;
	
	public TaxCollectorAttackedMessage() {
	}
	
	public TaxCollectorAttackedMessage(short firstNameId, short lastNameId, short worldX, short worldY, int mapId, short subAreaId, BasicGuildInformations guild) {
		this.firstNameId = firstNameId;
		this.lastNameId = lastNameId;
		this.worldX = worldX;
		this.worldY = worldY;
		this.mapId = mapId;
		this.subAreaId = subAreaId;
		this.guild = guild;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.firstNameId = reader.readShort();
		if (firstNameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on firstNameId = %s, it doesn't respect the following condition : firstNameId < 0", firstNameId));
		this.lastNameId = reader.readShort();
		if (lastNameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lastNameId = %s, it doesn't respect the following condition : lastNameId < 0", lastNameId));
		this.worldX = reader.readShort();
		if (worldX < -255 || worldX > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldX = %s, it doesn't respect the following condition : worldX < -255 || worldX > 255", worldX));
		this.worldY = reader.readShort();
		if (worldY < -255 || worldY > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldY = %s, it doesn't respect the following condition : worldY < -255 || worldY > 255", worldY));
		this.mapId = reader.readInt();
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.guild = new BasicGuildInformations();
		this.guild.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.firstNameId);
		writer.writeShort(this.lastNameId);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeInt(this.mapId);
		writer.writeShort(this.subAreaId);
		this.guild.serialize(writer);
	}
}