package org.chuckame.dofus2.protocol.types.game.character.status;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.character.status.PlayerStatus;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class PlayerStatusExtended extends PlayerStatus {
	public static final short TYPE_ID = 414;
	
	private String message;
	
	public PlayerStatusExtended() {
	}
	
	public PlayerStatusExtended(byte statusId, String message) {
		super(statusId);
		this.message = message;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.message = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.message);
	}
}