package org.chuckame.dofus2.protocol.types.game.guild.tax;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.guild.tax.AdditionalTaxCollectorInformations;
import org.chuckame.dofus2.protocol.types.game.guild.tax.TaxCollectorComplementaryInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class TaxCollectorInformations implements INetworkType {
	public static final short TYPE_ID = 167;
	
	private int uniqueId;
	private short firtNameId;
	private short lastNameId;
	private AdditionalTaxCollectorInformations additionalInfos;
	private short worldX;
	private short worldY;
	private short subAreaId;
	private byte state;
	private EntityLook look;
	private Collection<TaxCollectorComplementaryInformations> complements;
	
	public TaxCollectorInformations() {
	}
	
	public TaxCollectorInformations(int uniqueId, short firtNameId, short lastNameId, AdditionalTaxCollectorInformations additionalInfos, short worldX, short worldY, short subAreaId, byte state, EntityLook look, Collection<TaxCollectorComplementaryInformations> complements) {
		this.uniqueId = uniqueId;
		this.firtNameId = firtNameId;
		this.lastNameId = lastNameId;
		this.additionalInfos = additionalInfos;
		this.worldX = worldX;
		this.worldY = worldY;
		this.subAreaId = subAreaId;
		this.state = state;
		this.look = look;
		this.complements = complements;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.uniqueId = reader.readInt();
		this.firtNameId = reader.readShort();
		if (firtNameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on firtNameId = %s, it doesn't respect the following condition : firtNameId < 0", firtNameId));
		this.lastNameId = reader.readShort();
		if (lastNameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lastNameId = %s, it doesn't respect the following condition : lastNameId < 0", lastNameId));
		this.additionalInfos = new AdditionalTaxCollectorInformations();
		this.additionalInfos.deserialize(reader);
		this.worldX = reader.readShort();
		if (worldX < -255 || worldX > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldX = %s, it doesn't respect the following condition : worldX < -255 || worldX > 255", worldX));
		this.worldY = reader.readShort();
		if (worldY < -255 || worldY > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldY = %s, it doesn't respect the following condition : worldY < -255 || worldY > 255", worldY));
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.state = reader.readSByte();
		if (state < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on state = %s, it doesn't respect the following condition : state < 0", state));
		this.look = new EntityLook();
		this.look.deserialize(reader);
		int length = reader.readUShort();
		this.complements = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			TaxCollectorComplementaryInformations entry = ProtocolTypeManager.getInstance().<TaxCollectorComplementaryInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.complements.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.uniqueId);
		writer.writeShort(this.firtNameId);
		writer.writeShort(this.lastNameId);
		this.additionalInfos.serialize(writer);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeShort(this.subAreaId);
		writer.writeSByte(this.state);
		this.look.serialize(writer);
		writer.writeUShort(this.complements.size());
		for (TaxCollectorComplementaryInformations entry : this.complements)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
	}
}