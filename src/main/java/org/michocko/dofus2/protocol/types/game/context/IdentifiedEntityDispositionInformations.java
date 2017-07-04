package org.michocko.dofus2.protocol.types.game.context;

import org.michocko.dofus2.protocol.types.game.context.EntityDispositionInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class IdentifiedEntityDispositionInformations extends EntityDispositionInformations {
	public static final short TYPE_ID = 107;
	
	private int id;
	
	public IdentifiedEntityDispositionInformations() {
	}
	
	public IdentifiedEntityDispositionInformations(short cellId, byte direction, int id) {
		super(cellId, direction);
		this.id = id;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.id = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.id);
	}
}