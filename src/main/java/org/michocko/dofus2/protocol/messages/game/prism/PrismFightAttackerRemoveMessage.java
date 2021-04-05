package org.michocko.dofus2.protocol.messages.game.prism;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PrismFightAttackerRemoveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5897;
	
	private short subAreaId;
	private double fightId;
	private int fighterToRemoveId;
	
	public PrismFightAttackerRemoveMessage() {
	}
	
	public PrismFightAttackerRemoveMessage(short subAreaId, double fightId, int fighterToRemoveId) {
		this.subAreaId = subAreaId;
		this.fightId = fightId;
		this.fighterToRemoveId = fighterToRemoveId;
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
		this.fighterToRemoveId = reader.readInt();
		if (fighterToRemoveId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fighterToRemoveId = %s, it doesn't respect the following condition : fighterToRemoveId < 0", fighterToRemoveId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.subAreaId);
		writer.writeDouble(this.fightId);
		writer.writeInt(this.fighterToRemoveId);
	}
}