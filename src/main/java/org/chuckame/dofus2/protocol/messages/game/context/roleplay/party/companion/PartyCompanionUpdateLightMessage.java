package org.chuckame.dofus2.protocol.messages.game.context.roleplay.party.companion;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.party.PartyUpdateLightMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyCompanionUpdateLightMessage extends PartyUpdateLightMessage {
	public static final int MESSAGE_ID = 6472;
	
	private byte indexId;
	
	public PartyCompanionUpdateLightMessage() {
	}
	
	public PartyCompanionUpdateLightMessage(int partyId, int id, int lifePoints, int maxLifePoints, short prospecting, short regenRate, byte indexId) {
		super(partyId, id, lifePoints, maxLifePoints, prospecting, regenRate);
		this.indexId = indexId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.indexId = reader.readSByte();
		if (indexId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on indexId = %s, it doesn't respect the following condition : indexId < 0", indexId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.indexId);
	}
}