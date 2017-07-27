package org.chuckame.dofus2.protocol.messages.game.context.roleplay.job;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.job.JobAllowMultiCraftRequestMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class JobMultiCraftAvailableSkillsMessage extends JobAllowMultiCraftRequestMessage {
	public static final int MESSAGE_ID = 5747;
	
	private int playerId;
	private Collection<Short> skills;
	
	public JobMultiCraftAvailableSkillsMessage() {
	}
	
	public JobMultiCraftAvailableSkillsMessage(boolean enabled, int playerId, Collection<Short> skills) {
		super(enabled);
		this.playerId = playerId;
		this.skills = skills;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		int length = reader.readUShort();
		this.skills = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.skills.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.playerId);
		writer.writeUShort(this.skills.size());
		for (short entry : this.skills)
		{
			writer.writeShort(entry);
		}
	}
}