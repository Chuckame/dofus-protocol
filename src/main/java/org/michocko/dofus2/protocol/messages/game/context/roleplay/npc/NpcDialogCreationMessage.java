package org.michocko.dofus2.protocol.messages.game.context.roleplay.npc;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.mapId = reader.readInt();
		this.npcId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.mapId);
		writer.writeInt(this.npcId);
	}
}