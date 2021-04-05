package org.michocko.dofus2.protocol.messages.connection;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.version.VersionExtended;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class IdentificationMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 4;
	
	private VersionExtended version;
	private String lang;
	private Collection<Byte> credentials;
	private short serverId;
	private double sessionOptionalSalt;
	
	public IdentificationMessage() {
	}
	
	public IdentificationMessage(VersionExtended version, String lang, Collection<Byte> credentials, short serverId, double sessionOptionalSalt) {
		this.version = version;
		this.lang = lang;
		this.credentials = credentials;
		this.serverId = serverId;
		this.sessionOptionalSalt = sessionOptionalSalt;
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
		this.version = new VersionExtended();
		this.version.deserialize(reader);
		this.lang = reader.readUTF();
		int length = reader.readUShort();
		this.credentials = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			byte entry = reader.readSByte();
			this.credentials.add(entry);
		}
		this.serverId = reader.readShort();
		this.sessionOptionalSalt = reader.readDouble();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.version.serialize(writer);
		writer.writeUTF(this.lang);
		writer.writeUShort(this.credentials.size());
		for (byte entry : this.credentials)
		{
			writer.writeSByte(entry);
		}
		writer.writeShort(this.serverId);
		writer.writeDouble(this.sessionOptionalSalt);
	}
}