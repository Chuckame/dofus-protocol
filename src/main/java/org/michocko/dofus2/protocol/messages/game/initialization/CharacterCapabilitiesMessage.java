package org.michocko.dofus2.protocol.messages.game.initialization;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CharacterCapabilitiesMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6339;
	
	private int guildEmblemSymbolCategories;
	
	public CharacterCapabilitiesMessage() {
	}
	
	public CharacterCapabilitiesMessage(int guildEmblemSymbolCategories) {
		this.guildEmblemSymbolCategories = guildEmblemSymbolCategories;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.guildEmblemSymbolCategories = reader.readInt();
		if (guildEmblemSymbolCategories < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on guildEmblemSymbolCategories = %s, it doesn't respect the following condition : guildEmblemSymbolCategories < 0", guildEmblemSymbolCategories));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.guildEmblemSymbolCategories);
	}
}