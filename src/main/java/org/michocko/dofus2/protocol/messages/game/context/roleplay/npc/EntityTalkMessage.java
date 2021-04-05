package org.michocko.dofus2.protocol.messages.game.context.roleplay.npc;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class EntityTalkMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6110;
	
	private int entityId;
	private short textId;
	private Collection<String> parameters;
	
	public EntityTalkMessage() {
	}
	
	public EntityTalkMessage(int entityId, short textId, Collection<String> parameters) {
		this.entityId = entityId;
		this.textId = textId;
		this.parameters = parameters;
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
		this.entityId = reader.readInt();
		this.textId = reader.readShort();
		if (textId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on textId = %s, it doesn't respect the following condition : textId < 0", textId));
		int length = reader.readUShort();
		this.parameters = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			String entry = reader.readUTF();
			this.parameters.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.entityId);
		writer.writeShort(this.textId);
		writer.writeUShort(this.parameters.size());
		for (String entry : this.parameters)
		{
			writer.writeUTF(entry);
		}
	}
}