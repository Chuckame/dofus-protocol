package org.chuckame.dofus2.protocol.messages.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GameRolePlayActorInformations;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.informations = ProtocolTypeManager.getInstance().<GameRolePlayActorInformations>newInstance(reader.readShort());
		this.informations.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.informations.getProtocolTypeId());
		this.informations.serialize(writer);
	}
}