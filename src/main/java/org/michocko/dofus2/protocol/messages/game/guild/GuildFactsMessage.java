package org.michocko.dofus2.protocol.messages.game.guild;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.social.GuildFactSheetInformations;
import org.michocko.dofus2.protocol.types.game.character.CharacterMinimalInformations;

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
public class GuildFactsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6415;
	
	private GuildFactSheetInformations infos;
	private int creationDate;
	private short nbTaxCollectors;
	private boolean enabled;
	private Collection<CharacterMinimalInformations> members;
	
	public GuildFactsMessage() {
	}
	
	public GuildFactsMessage(GuildFactSheetInformations infos, int creationDate, short nbTaxCollectors, boolean enabled, Collection<CharacterMinimalInformations> members) {
		this.infos = infos;
		this.creationDate = creationDate;
		this.nbTaxCollectors = nbTaxCollectors;
		this.enabled = enabled;
		this.members = members;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.infos = ProtocolTypeManager.getInstance().<GuildFactSheetInformations>newInstance(reader.readShort());
		this.infos.deserialize(reader);
		this.creationDate = reader.readInt();
		if (creationDate < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on creationDate = %s, it doesn't respect the following condition : creationDate < 0", creationDate));
		this.nbTaxCollectors = reader.readShort();
		if (nbTaxCollectors < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbTaxCollectors = %s, it doesn't respect the following condition : nbTaxCollectors < 0", nbTaxCollectors));
		this.enabled = reader.readBoolean();
		int length = reader.readUShort();
		this.members = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			CharacterMinimalInformations entry = new CharacterMinimalInformations();
			entry.deserialize(reader);
			this.members.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.infos.getNetworkTypeId());
		this.infos.serialize(writer);
		writer.writeInt(this.creationDate);
		writer.writeShort(this.nbTaxCollectors);
		writer.writeBoolean(this.enabled);
		writer.writeUShort(this.members.size());
		for (CharacterMinimalInformations entry : this.members)
		{
			entry.serialize(writer);
		}
	}
}