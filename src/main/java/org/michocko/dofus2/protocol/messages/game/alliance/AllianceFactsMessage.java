package org.michocko.dofus2.protocol.messages.game.alliance;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.social.AllianceFactSheetInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.GuildInAllianceInformations;

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
public class AllianceFactsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6414;
	
	private AllianceFactSheetInformations infos;
	private Collection<GuildInAllianceInformations> guilds;
	private Collection<Short> controlledSubareaIds;
	
	public AllianceFactsMessage() {
	}
	
	public AllianceFactsMessage(AllianceFactSheetInformations infos, Collection<GuildInAllianceInformations> guilds, Collection<Short> controlledSubareaIds) {
		this.infos = infos;
		this.guilds = guilds;
		this.controlledSubareaIds = controlledSubareaIds;
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
		this.infos = (AllianceFactSheetInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
		this.infos.deserialize(reader);
		int length = reader.readUShort();
		this.guilds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GuildInAllianceInformations entry = new GuildInAllianceInformations();
			entry.deserialize(reader);
			this.guilds.add(entry);
		}
		length = reader.readUShort();
		this.controlledSubareaIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.controlledSubareaIds.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.infos.getNetworkTypeId());
		this.infos.serialize(writer);
		writer.writeUShort(this.guilds.size());
		for (GuildInAllianceInformations entry : this.guilds)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.controlledSubareaIds.size());
		for (short entry : this.controlledSubareaIds)
		{
			writer.writeShort(entry);
		}
	}
}