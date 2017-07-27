package org.chuckame.dofus2.protocol.messages.game.context.roleplay.party;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyEventMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyUpdateLightMessage extends AbstractPartyEventMessage {
	public static final int MESSAGE_ID = 6054;
	
	private int id;
	private int lifePoints;
	private int maxLifePoints;
	private short prospecting;
	private short regenRate;
	
	public PartyUpdateLightMessage() {
	}
	
	public PartyUpdateLightMessage(int partyId, int id, int lifePoints, int maxLifePoints, short prospecting, short regenRate) {
		super(partyId);
		this.id = id;
		this.lifePoints = lifePoints;
		this.maxLifePoints = maxLifePoints;
		this.prospecting = prospecting;
		this.regenRate = regenRate;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.id = reader.readInt();
		if (id < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0", id));
		this.lifePoints = reader.readInt();
		if (lifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lifePoints = %s, it doesn't respect the following condition : lifePoints < 0", lifePoints));
		this.maxLifePoints = reader.readInt();
		if (maxLifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxLifePoints = %s, it doesn't respect the following condition : maxLifePoints < 0", maxLifePoints));
		this.prospecting = reader.readShort();
		if (prospecting < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on prospecting = %s, it doesn't respect the following condition : prospecting < 0", prospecting));
		this.regenRate = reader.readByte();
		if (regenRate < 0 || regenRate > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on regenRate = %s, it doesn't respect the following condition : regenRate < 0 || regenRate > 255", regenRate));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.id);
		writer.writeInt(this.lifePoints);
		writer.writeInt(this.maxLifePoints);
		writer.writeShort(this.prospecting);
		writer.writeByte(this.regenRate);
	}
}