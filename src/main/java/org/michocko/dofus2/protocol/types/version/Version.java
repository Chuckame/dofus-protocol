package org.michocko.dofus2.protocol.types.version;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class Version implements INetworkType {
	public static final short TYPE_ID = 11;
	
	private byte major;
	private byte minor;
	private byte release;
	private int revision;
	private byte patch;
	private byte buildType;
	
	public Version() {
	}
	
	public Version(byte major, byte minor, byte release, int revision, byte patch, byte buildType) {
		this.major = major;
		this.minor = minor;
		this.release = release;
		this.revision = revision;
		this.patch = patch;
		this.buildType = buildType;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.major = reader.readSByte();
		if (major < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on major = %s, it doesn't respect the following condition : major < 0", major));
		this.minor = reader.readSByte();
		if (minor < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on minor = %s, it doesn't respect the following condition : minor < 0", minor));
		this.release = reader.readSByte();
		if (release < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on release = %s, it doesn't respect the following condition : release < 0", release));
		this.revision = reader.readInt();
		if (revision < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on revision = %s, it doesn't respect the following condition : revision < 0", revision));
		this.patch = reader.readSByte();
		if (patch < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on patch = %s, it doesn't respect the following condition : patch < 0", patch));
		this.buildType = reader.readSByte();
		if (buildType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on buildType = %s, it doesn't respect the following condition : buildType < 0", buildType));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.major);
		writer.writeSByte(this.minor);
		writer.writeSByte(this.release);
		writer.writeInt(this.revision);
		writer.writeSByte(this.patch);
		writer.writeSByte(this.buildType);
	}
}