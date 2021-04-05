package org.michocko.dofus2.protocol.messages.game.context.roleplay;

import org.michocko.dofus2.protocol.types.game.context.roleplay.GameRolePlayActorInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameRolePlayShowActorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5632;
	
	private GameRolePlayActorInformations informations;
	
	public GameRolePlayShowActorMessage() {
	}
	
	public GameRolePlayShowActorMessage(GameRolePlayActorInformations informations) {
		this.informations = informations;
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
		this.informations = (GameRolePlayActorInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
		this.informations.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.informations.getNetworkTypeId());
		this.informations.serialize(writer);
	}
}