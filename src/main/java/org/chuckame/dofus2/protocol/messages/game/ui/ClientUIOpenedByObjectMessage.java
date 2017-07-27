package org.chuckame.dofus2.protocol.messages.game.ui;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.ui.ClientUIOpenedMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ClientUIOpenedByObjectMessage extends ClientUIOpenedMessage {
	public static final int MESSAGE_ID = 6463;
	
	private int uid;
	
	public ClientUIOpenedByObjectMessage() {
	}
	
	public ClientUIOpenedByObjectMessage(byte type, int uid) {
		super(type);
		this.uid = uid;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.uid = reader.readInt();
		if (uid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on uid = %s, it doesn't respect the following condition : uid < 0", uid));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.uid);
	}
}