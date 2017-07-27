package org.chuckame.dofus2.protocol.types.game.character.status;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class PlayerStatus implements INetworkType {
	public static final short TYPE_ID = 415;
	
	private byte statusId;
	
	public PlayerStatus() {
	}
	
	public PlayerStatus(byte statusId) {
		this.statusId = statusId;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.statusId = reader.readSByte();
		if (statusId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on statusId = %s, it doesn't respect the following condition : statusId < 0", statusId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.statusId);
	}
}