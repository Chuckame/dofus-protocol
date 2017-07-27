package org.chuckame.dofus2.protocol.messages.game.context.roleplay.npc;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class NpcDialogCreationMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5618;
	
	private int mapId;
	private int npcId;
	
	public NpcDialogCreationMessage() {
	}
	
	public NpcDialogCreationMessage(int mapId, int npcId) {
		this.mapId = mapId;
		this.npcId = npcId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mapId = reader.readInt();
		this.npcId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.mapId);
		writer.writeInt(this.npcId);
	}
}