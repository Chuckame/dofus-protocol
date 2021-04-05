package org.michocko.dofus2.protocol.types.game.paddock;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class MountInformationsForPaddock implements INetworkType {
	public static final short TYPE_ID = 184;
	
	private int modelId;
	private String name;
	private String ownerName;
	
	public MountInformationsForPaddock() {
	}
	
	public MountInformationsForPaddock(int modelId, String name, String ownerName) {
		this.modelId = modelId;
		this.name = name;
		this.ownerName = ownerName;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.modelId = reader.readInt();
		this.name = reader.readUTF();
		this.ownerName = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.modelId);
		writer.writeUTF(this.name);
		writer.writeUTF(this.ownerName);
	}
}