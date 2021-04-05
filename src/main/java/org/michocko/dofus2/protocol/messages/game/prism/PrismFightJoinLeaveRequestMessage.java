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
public class PrismFightJoinLeaveRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5843;
	
	private short subAreaId;
	private boolean join;
	
	public PrismFightJoinLeaveRequestMessage() {
	}
	
	public PrismFightJoinLeaveRequestMessage(short subAreaId, boolean join) {
		this.subAreaId = subAreaId;
		this.join = join;
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
		this.join = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.subAreaId);
		writer.writeBoolean(this.join);
	}
}