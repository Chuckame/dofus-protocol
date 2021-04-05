package org.michocko.dofus2.protocol.types.game.context.roleplay.quest;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class QuestObjectiveInformations implements INetworkType {
	public static final short TYPE_ID = 385;
	
	private short objectiveId;
	private boolean objectiveStatus;
	private Collection<String> dialogParams;
	
	public QuestObjectiveInformations() {
	}
	
	public QuestObjectiveInformations(short objectiveId, boolean objectiveStatus, Collection<String> dialogParams) {
		this.objectiveId = objectiveId;
		this.objectiveStatus = objectiveStatus;
		this.dialogParams = dialogParams;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.objectiveId = reader.readShort();
		if (objectiveId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectiveId = %s, it doesn't respect the following condition : objectiveId < 0", objectiveId));
		this.objectiveStatus = reader.readBoolean();
		int length = reader.readUShort();
		this.dialogParams = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			String entry = reader.readUTF();
			this.dialogParams.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.objectiveId);
		writer.writeBoolean(this.objectiveStatus);
		writer.writeUShort(this.dialogParams.size());
		for (String entry : this.dialogParams)
		{
			writer.writeUTF(entry);
		}
	}
}