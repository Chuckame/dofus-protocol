package org.michocko.dofus2.protocol.messages.game.guild;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.paddock.PaddockContentInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildInformationsPaddocksMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5959;
	
	private byte nbPaddockMax;
	private Collection<PaddockContentInformations> paddocksInformations;
	
	public GuildInformationsPaddocksMessage() {
	}
	
	public GuildInformationsPaddocksMessage(byte nbPaddockMax, Collection<PaddockContentInformations> paddocksInformations) {
		this.nbPaddockMax = nbPaddockMax;
		this.paddocksInformations = paddocksInformations;
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
		this.nbPaddockMax = reader.readSByte();
		if (nbPaddockMax < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbPaddockMax = %s, it doesn't respect the following condition : nbPaddockMax < 0", nbPaddockMax));
		int length = reader.readUShort();
		this.paddocksInformations = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PaddockContentInformations entry = new PaddockContentInformations();
			entry.deserialize(reader);
			this.paddocksInformations.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.nbPaddockMax);
		writer.writeUShort(this.paddocksInformations.size());
		for (PaddockContentInformations entry : this.paddocksInformations)
		{
			entry.serialize(writer);
		}
	}
}