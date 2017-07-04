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
public class NpcGenericActionRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5898;
	
	private int npcId;
	private byte npcActionId;
	private int npcMapId;
	
	public NpcGenericActionRequestMessage() {
	}
	
	public NpcGenericActionRequestMessage(int npcId, byte npcActionId, int npcMapId) {
		this.npcId = npcId;
		this.npcActionId = npcActionId;
		this.npcMapId = npcMapId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.npcId = reader.readInt();
		this.npcActionId = reader.readSByte();
		if (npcActionId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on npcActionId = %s, it doesn't respect the following condition : npcActionId < 0", npcActionId));
		this.npcMapId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.npcId);
		writer.writeSByte(this.npcActionId);
		writer.writeInt(this.npcMapId);
	}
}