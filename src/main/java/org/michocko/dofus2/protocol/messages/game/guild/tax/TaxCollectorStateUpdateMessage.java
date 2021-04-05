package org.michocko.dofus2.protocol.messages.game.guild.tax;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TaxCollectorStateUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6455;
	
	private int uniqueId;
	private byte state;
	
	public TaxCollectorStateUpdateMessage() {
	}
	
	public TaxCollectorStateUpdateMessage(int uniqueId, byte state) {
		this.uniqueId = uniqueId;
		this.state = state;
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
		this.uniqueId = reader.readInt();
		this.state = reader.readSByte();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.uniqueId);
		writer.writeSByte(this.state);
	}
}