package org.michocko.dofus2.protocol.messages.game.basic;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class BasicLatencyStatsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5663;
	
	private int latency;
	private short sampleCount;
	private short max;
	
	public BasicLatencyStatsMessage() {
	}
	
	public BasicLatencyStatsMessage(int latency, short sampleCount, short max) {
		this.latency = latency;
		this.sampleCount = sampleCount;
		this.max = max;
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
		this.latency = reader.readUShort();
		if (latency < 0 || latency > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on latency = %s, it doesn't respect the following condition : latency < 0 || latency > 65535", latency));
		this.sampleCount = reader.readShort();
		if (sampleCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on sampleCount = %s, it doesn't respect the following condition : sampleCount < 0", sampleCount));
		this.max = reader.readShort();
		if (max < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on max = %s, it doesn't respect the following condition : max < 0", max));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.latency);
		writer.writeShort(this.sampleCount);
		writer.writeShort(this.max);
	}
}