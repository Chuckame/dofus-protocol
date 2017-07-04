package org.michocko.dofus2.protocol.messages.connection;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.version.VersionExtended;
import org.michocko.dofus2.protocol.messages.connection.IdentificationMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class IdentificationAccountForceMessage extends IdentificationMessage {
	public static final int MESSAGE_ID = 6119;
	
	private String forcedAccountLogin;
	
	public IdentificationAccountForceMessage() {
	}
	
	public IdentificationAccountForceMessage(VersionExtended version, String lang, Collection<Byte> credentials, short serverId, double sessionOptionalSalt, String forcedAccountLogin) {
		super(version, lang, credentials, serverId, sessionOptionalSalt);
		this.forcedAccountLogin = forcedAccountLogin;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.forcedAccountLogin = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.forcedAccountLogin);
	}
}