package org.michocko.dofus2.protocol.messages.game.alliance;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.social.AllianceFactSheetInformations;
import org.michocko.dofus2.protocol.types.game.social.GuildInsiderFactSheetInformations;
import org.michocko.dofus2.protocol.types.game.prism.PrismSubareaEmptyInfo;

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
public class AllianceInsiderInfoMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6403;
	
	private AllianceFactSheetInformations allianceInfos;
	private Collection<GuildInsiderFactSheetInformations> guilds;
	private Collection<PrismSubareaEmptyInfo> prisms;
	
	public AllianceInsiderInfoMessage() {
	}
	
	public AllianceInsiderInfoMessage(AllianceFactSheetInformations allianceInfos, Collection<GuildInsiderFactSheetInformations> guilds, Collection<PrismSubareaEmptyInfo> prisms) {
		this.allianceInfos = allianceInfos;
		this.guilds = guilds;
		this.prisms = prisms;
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
		this.allianceInfos = new AllianceFactSheetInformations();
		this.allianceInfos.deserialize(reader);
		int length = reader.readUShort();
		this.guilds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GuildInsiderFactSheetInformations entry = new GuildInsiderFactSheetInformations();
			entry.deserialize(reader);
			this.guilds.add(entry);
		}
		length = reader.readUShort();
		this.prisms = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PrismSubareaEmptyInfo entry = (PrismSubareaEmptyInfo) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
			entry.deserialize(reader);
			this.prisms.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.allianceInfos.serialize(writer);
		writer.writeUShort(this.guilds.size());
		for (GuildInsiderFactSheetInformations entry : this.guilds)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.prisms.size());
		for (PrismSubareaEmptyInfo entry : this.prisms)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}