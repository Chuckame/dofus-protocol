package org.chuckame.dofus2.protocol.messages.game.inventory.items;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.inventory.items.ObjectErrorMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class MimicryObjectErrorMessage extends ObjectErrorMessage {
	public static final int MESSAGE_ID = 6461;
	
	private boolean preview;
	private byte errorCode;
	
	public MimicryObjectErrorMessage() {
	}
	
	public MimicryObjectErrorMessage(byte reason, boolean preview, byte errorCode) {
		super(reason);
		this.preview = preview;
		this.errorCode = errorCode;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.preview = reader.readBoolean();
		this.errorCode = reader.readSByte();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeBoolean(this.preview);
		writer.writeSByte(this.errorCode);
	}
}