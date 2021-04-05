package org.michocko.dofus2.protocol.messages.game.interactive;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class InteractiveUseErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6384;
	
	private int elemId;
	private int skillInstanceUid;
	
	public InteractiveUseErrorMessage() {
	}
	
	public InteractiveUseErrorMessage(int elemId, int skillInstanceUid) {
		this.elemId = elemId;
		this.skillInstanceUid = skillInstanceUid;
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
		this.elemId = reader.readInt();
		if (elemId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on elemId = %s, it doesn't respect the following condition : elemId < 0", elemId));
		this.skillInstanceUid = reader.readInt();
		if (skillInstanceUid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skillInstanceUid = %s, it doesn't respect the following condition : skillInstanceUid < 0", skillInstanceUid));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.elemId);
		writer.writeInt(this.skillInstanceUid);
	}
}