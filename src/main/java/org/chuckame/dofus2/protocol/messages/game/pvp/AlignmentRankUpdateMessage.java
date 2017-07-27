package org.chuckame.dofus2.protocol.messages.game.pvp;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.alignmentRank = reader.readSByte();
		if (alignmentRank < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on alignmentRank = %s, it doesn't respect the following condition : alignmentRank < 0", alignmentRank));
		this.verbose = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.alignmentRank);
		writer.writeBoolean(this.verbose);
	}
}