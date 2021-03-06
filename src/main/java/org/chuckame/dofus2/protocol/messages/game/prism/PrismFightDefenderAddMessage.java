package org.chuckame.dofus2.protocol.messages.game.prism;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.character.CharacterMinimalPlusLookInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PrismFightDefenderAddMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5895;
	
	private short subAreaId;
	private double fightId;
	private CharacterMinimalPlusLookInformations defender;
	
	public PrismFightDefenderAddMessage() {
	}
	
	public PrismFightDefenderAddMessage(short subAreaId, double fightId, CharacterMinimalPlusLookInformations defender) {
		this.subAreaId = subAreaId;
		this.fightId = fightId;
		this.defender = defender;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.fightId = reader.readDouble();
		this.defender = ProtocolTypeManager.getInstance().<CharacterMinimalPlusLookInformations>newInstance(reader.readShort());
		this.defender.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.subAreaId);
		writer.writeDouble(this.fightId);
		writer.writeShort(this.defender.getProtocolTypeId());
		this.defender.serialize(writer);
	}
}