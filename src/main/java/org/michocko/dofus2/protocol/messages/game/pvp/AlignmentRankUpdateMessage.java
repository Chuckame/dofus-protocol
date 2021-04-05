package org.michocko.dofus2.protocol.messages.game.pvp;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AlignmentRankUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6058;
	
	private byte alignmentRank;
	private boolean verbose;
	
	public AlignmentRankUpdateMessage() {
	}
	
	public AlignmentRankUpdateMessage(byte alignmentRank, boolean verbose) {
		this.alignmentRank = alignmentRank;
		this.verbose = verbose;
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
		this.alignmentRank = reader.readSByte();
		if (alignmentRank < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on alignmentRank = %s, it doesn't respect the following condition : alignmentRank < 0", alignmentRank));
		this.verbose = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.alignmentRank);
		writer.writeBoolean(this.verbose);
	}
}