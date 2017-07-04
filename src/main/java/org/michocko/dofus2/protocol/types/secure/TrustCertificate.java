package org.michocko.dofus2.protocol.types.secure;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class TrustCertificate implements INetworkType {
	public static final short TYPE_ID = 377;
	
	private int id;
	private String hash;
	
	public TrustCertificate() {
	}
	
	public TrustCertificate(int id, String hash) {
		this.id = id;
		this.hash = hash;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
		if (id < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0", id));
		this.hash = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
		writer.writeUTF(this.hash);
	}
}