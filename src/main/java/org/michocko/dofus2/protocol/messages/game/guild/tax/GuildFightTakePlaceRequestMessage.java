package org.michocko.dofus2.protocol.messages.game.guild.tax;

import org.michocko.dofus2.protocol.messages.game.guild.tax.GuildFightJoinRequestMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GuildFightTakePlaceRequestMessage extends GuildFightJoinRequestMessage {
	public static final int MESSAGE_ID = 6235;
	
	private int replacedCharacterId;
	
	public GuildFightTakePlaceRequestMessage() {
	}
	
	public GuildFightTakePlaceRequestMessage(int taxCollectorId, int replacedCharacterId) {
		super(taxCollectorId);
		this.replacedCharacterId = replacedCharacterId;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.replacedCharacterId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.replacedCharacterId);
	}
}