package org.chuckame.dofus2.protocol.types.version;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.version.Version;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class VersionExtended extends Version {
	public static final short TYPE_ID = 393;
	
	private byte install;
	private byte technology;
	
	public VersionExtended() {
	}
	
	public VersionExtended(byte major, byte minor, byte release, int revision, byte patch, byte buildType, byte install, byte technology) {
		super(major, minor, release, revision, patch, buildType);
		this.install = install;
		this.technology = technology;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.install = reader.readSByte();
		if (install < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on install = %s, it doesn't respect the following condition : install < 0", install));
		this.technology = reader.readSByte();
		if (technology < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on technology = %s, it doesn't respect the following condition : technology < 0", technology));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.install);
		writer.writeSByte(this.technology);
	}
}