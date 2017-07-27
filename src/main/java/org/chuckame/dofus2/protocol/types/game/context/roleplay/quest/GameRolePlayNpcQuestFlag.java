package org.chuckame.dofus2.protocol.types.game.context.roleplay.quest;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class GameRolePlayNpcQuestFlag implements INetworkType {
	public static final short TYPE_ID = 384;
	
	private Collection<Short> questsToValidId;
	private Collection<Short> questsToStartId;
	
	public GameRolePlayNpcQuestFlag() {
	}
	
	public GameRolePlayNpcQuestFlag(Collection<Short> questsToValidId, Collection<Short> questsToStartId) {
		this.questsToValidId = questsToValidId;
		this.questsToStartId = questsToStartId;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.questsToValidId = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.questsToValidId.add(entry);
		}
		length = reader.readUShort();
		this.questsToStartId = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.questsToStartId.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.questsToValidId.size());
		for (short entry : this.questsToValidId)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.questsToStartId.size());
		for (short entry : this.questsToStartId)
		{
			writer.writeShort(entry);
		}
	}
}