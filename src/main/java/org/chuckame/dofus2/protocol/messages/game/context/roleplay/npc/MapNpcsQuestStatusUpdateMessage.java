package org.chuckame.dofus2.protocol.messages.game.context.roleplay.npc;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.quest.GameRolePlayNpcQuestFlag;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MapNpcsQuestStatusUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5642;
	
	private int mapId;
	private Collection<Integer> npcsIdsWithQuest;
	private Collection<GameRolePlayNpcQuestFlag> questFlags;
	private Collection<Integer> npcsIdsWithoutQuest;
	
	public MapNpcsQuestStatusUpdateMessage() {
	}
	
	public MapNpcsQuestStatusUpdateMessage(int mapId, Collection<Integer> npcsIdsWithQuest, Collection<GameRolePlayNpcQuestFlag> questFlags, Collection<Integer> npcsIdsWithoutQuest) {
		this.mapId = mapId;
		this.npcsIdsWithQuest = npcsIdsWithQuest;
		this.questFlags = questFlags;
		this.npcsIdsWithoutQuest = npcsIdsWithoutQuest;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mapId = reader.readInt();
		int length = reader.readUShort();
		this.npcsIdsWithQuest = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.npcsIdsWithQuest.add(entry);
		}
		length = reader.readUShort();
		this.questFlags = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GameRolePlayNpcQuestFlag entry = new GameRolePlayNpcQuestFlag();
			entry.deserialize(reader);
			this.questFlags.add(entry);
		}
		length = reader.readUShort();
		this.npcsIdsWithoutQuest = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.npcsIdsWithoutQuest.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.mapId);
		writer.writeUShort(this.npcsIdsWithQuest.size());
		for (int entry : this.npcsIdsWithQuest)
		{
			writer.writeInt(entry);
		}
		writer.writeUShort(this.questFlags.size());
		for (GameRolePlayNpcQuestFlag entry : this.questFlags)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.npcsIdsWithoutQuest.size());
		for (int entry : this.npcsIdsWithoutQuest)
		{
			writer.writeInt(entry);
		}
	}
}