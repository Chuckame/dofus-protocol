package org.michocko.dofus2.protocol.messages.game.character.stats;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CharacterExperienceGainMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6321;
	
	private double experienceCharacter;
	private double experienceMount;
	private double experienceGuild;
	private double experienceIncarnation;
	
	public CharacterExperienceGainMessage() {
	}
	
	public CharacterExperienceGainMessage(double experienceCharacter, double experienceMount, double experienceGuild, double experienceIncarnation) {
		this.experienceCharacter = experienceCharacter;
		this.experienceMount = experienceMount;
		this.experienceGuild = experienceGuild;
		this.experienceIncarnation = experienceIncarnation;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.experienceCharacter = reader.readDouble();
		if (experienceCharacter < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experienceCharacter = %s, it doesn't respect the following condition : experienceCharacter < 0", experienceCharacter));
		this.experienceMount = reader.readDouble();
		if (experienceMount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experienceMount = %s, it doesn't respect the following condition : experienceMount < 0", experienceMount));
		this.experienceGuild = reader.readDouble();
		if (experienceGuild < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experienceGuild = %s, it doesn't respect the following condition : experienceGuild < 0", experienceGuild));
		this.experienceIncarnation = reader.readDouble();
		if (experienceIncarnation < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experienceIncarnation = %s, it doesn't respect the following condition : experienceIncarnation < 0", experienceIncarnation));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.experienceCharacter);
		writer.writeDouble(this.experienceMount);
		writer.writeDouble(this.experienceGuild);
		writer.writeDouble(this.experienceIncarnation);
	}
}