package org.chuckame.dofus2.protocol.messages.connection;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.connection.IdentificationFailedMessage;
import org.chuckame.dofus2.protocol.types.version.Version;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class IdentificationFailedForBadVersionMessage extends IdentificationFailedMessage {
	public static final int MESSAGE_ID = 21;
	
	private Version requiredVersion;
	
	public IdentificationFailedForBadVersionMessage() {
	}
	
	public IdentificationFailedForBadVersionMessage(byte reason, Version requiredVersion) {
		super(reason);
		this.requiredVersion = requiredVersion;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.requiredVersion = new Version();
		this.requiredVersion.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.requiredVersion.serialize(writer);
	}
}