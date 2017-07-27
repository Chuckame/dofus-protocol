package org.chuckame.dofus2.protocol.messages.game.actions.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.actions.AbstractGameActionMessage;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightChangeLookMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5532;
	
	private int targetId;
	private EntityLook entityLook;
	
	public GameActionFightChangeLookMessage() {
	}
	
	public GameActionFightChangeLookMessage(short actionId, int sourceId, int targetId, EntityLook entityLook) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.entityLook = entityLook;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.targetId = reader.readInt();
		this.entityLook = new EntityLook();
		this.entityLook.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		this.entityLook.serialize(writer);
	}
}