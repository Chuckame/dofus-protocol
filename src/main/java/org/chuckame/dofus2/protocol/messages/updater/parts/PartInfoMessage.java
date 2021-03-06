package org.chuckame.dofus2.protocol.messages.updater.parts;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.updater.ContentPart;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PartInfoMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1508;
	
	private ContentPart part;
	private float installationPercent;
	
	public PartInfoMessage() {
	}
	
	public PartInfoMessage(ContentPart part, float installationPercent) {
		this.part = part;
		this.installationPercent = installationPercent;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.part = new ContentPart();
		this.part.deserialize(reader);
		this.installationPercent = reader.readFloat();
	}
	
	public void serialize(IDataWriter writer) {
		this.part.serialize(writer);
		writer.writeFloat(this.installationPercent);
	}
}