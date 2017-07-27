package org.chuckame.dofus2.protocol.messages.game.guild.tax;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.guild.tax.GuildFightJoinRequestMessage;

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
	public int getProtocolId() {
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