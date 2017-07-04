package org.michocko.dofus2.protocol.messages.game.guild.tax;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.guild.tax.TaxCollectorInformations;
import org.michocko.dofus2.protocol.types.game.guild.tax.TaxCollectorFightersInformation;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TaxCollectorListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5930;
	
	private byte nbcollectorMax;
	private Collection<TaxCollectorInformations> informations;
	private Collection<TaxCollectorFightersInformation> fightersInformations;
	
	public TaxCollectorListMessage() {
	}
	
	public TaxCollectorListMessage(byte nbcollectorMax, Collection<TaxCollectorInformations> informations, Collection<TaxCollectorFightersInformation> fightersInformations) {
		this.nbcollectorMax = nbcollectorMax;
		this.informations = informations;
		this.fightersInformations = fightersInformations;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.nbcollectorMax = reader.readSByte();
		if (nbcollectorMax < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbcollectorMax = %s, it doesn't respect the following condition : nbcollectorMax < 0", nbcollectorMax));
		int length = reader.readUShort();
		this.informations = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			TaxCollectorInformations entry = ProtocolTypeManager.getInstance().<TaxCollectorInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.informations.add(entry);
		}
		length = reader.readUShort();
		this.fightersInformations = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			TaxCollectorFightersInformation entry = new TaxCollectorFightersInformation();
			entry.deserialize(reader);
			this.fightersInformations.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.nbcollectorMax);
		writer.writeUShort(this.informations.size());
		for (TaxCollectorInformations entry : this.informations)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
		writer.writeUShort(this.fightersInformations.size());
		for (TaxCollectorFightersInformation entry : this.fightersInformations)
		{
			entry.serialize(writer);
		}
	}
}