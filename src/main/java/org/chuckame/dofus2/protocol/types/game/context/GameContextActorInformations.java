package org.chuckame.dofus2.protocol.types.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class GameContextActorInformations implements INetworkType {
	public static final short TYPE_ID = 150;
	
	private int contextualId;
	private EntityLook look;
	private EntityDispositionInformations disposition;
	
	public GameContextActorInformations() {
	}
	
	public GameContextActorInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition) {
		this.contextualId = contextualId;
		this.look = look;
		this.disposition = disposition;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.contextualId = reader.readInt();
		this.look = new EntityLook();
		this.look.deserialize(reader);
		this.disposition = ProtocolTypeManager.getInstance().<EntityDispositionInformations>newInstance(reader.readShort());
		this.disposition.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.contextualId);
		this.look.serialize(writer);
		writer.writeShort(this.disposition.getProtocolTypeId());
		this.disposition.serialize(writer);
	}
}