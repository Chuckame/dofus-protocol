package org.michocko.dofus2.protocol.messages.game.context.roleplay;

import org.michocko.dofus2.protocol.types.game.context.roleplay.GameRolePlayActorInformations;
import org.michocko.dofus2.protocol.messages.game.context.roleplay.GameRolePlayShowActorMessage;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameRolePlayShowActorWithEventMessage extends GameRolePlayShowActorMessage {
	public static final int MESSAGE_ID = 6407;
	
	private byte actorEventId;
	
	public GameRolePlayShowActorWithEventMessage() {
	}
	
	public GameRolePlayShowActorWithEventMessage(GameRolePlayActorInformations informations, byte actorEventId) {
		super(informations);
		this.actorEventId = actorEventId;
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
		super.deserialize(reader);
		this.actorEventId = reader.readSByte();
		if (actorEventId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on actorEventId = %s, it doesn't respect the following condition : actorEventId < 0", actorEventId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.actorEventId);
	}
}