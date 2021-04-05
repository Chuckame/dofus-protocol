package org.michocko.dofus2.protocol.messages.game.prism;

import org.michocko.dofus2.protocol.types.game.character.CharacterMinimalPlusLookInformations;

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
public class PrismFightAttackerAddMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5893;
	
	private short subAreaId;
	private double fightId;
	private CharacterMinimalPlusLookInformations attacker;
	
	public PrismFightAttackerAddMessage() {
	}
	
	public PrismFightAttackerAddMessage(short subAreaId, double fightId, CharacterMinimalPlusLookInformations attacker) {
		this.subAreaId = subAreaId;
		this.fightId = fightId;
		this.attacker = attacker;
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
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.fightId = reader.readDouble();
		this.attacker = (CharacterMinimalPlusLookInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
		this.attacker.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.subAreaId);
		writer.writeDouble(this.fightId);
		writer.writeShort(this.attacker.getNetworkTypeId());
		this.attacker.serialize(writer);
	}
}