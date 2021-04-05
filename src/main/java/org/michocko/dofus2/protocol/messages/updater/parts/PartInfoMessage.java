package org.michocko.dofus2.protocol.messages.updater.parts;

import org.michocko.dofus2.protocol.types.updater.ContentPart;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.part = new ContentPart();
		this.part.deserialize(reader);
		this.installationPercent = reader.readFloat();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.part.serialize(writer);
		writer.writeFloat(this.installationPercent);
	}
}