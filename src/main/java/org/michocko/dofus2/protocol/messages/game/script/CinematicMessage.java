package org.michocko.dofus2.protocol.messages.game.script;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CinematicMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6053;
	
	private short cinematicId;
	
	public CinematicMessage() {
	}
	
	public CinematicMessage(short cinematicId) {
		this.cinematicId = cinematicId;
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
		this.cinematicId = reader.readShort();
		if (cinematicId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on cinematicId = %s, it doesn't respect the following condition : cinematicId < 0", cinematicId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.cinematicId);
	}
}