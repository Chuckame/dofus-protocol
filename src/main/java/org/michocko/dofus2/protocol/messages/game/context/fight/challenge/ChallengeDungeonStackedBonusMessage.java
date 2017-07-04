package org.michocko.dofus2.protocol.messages.game.context.fight.challenge;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ChallengeDungeonStackedBonusMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6151;
	
	private int dungeonId;
	private int xpBonus;
	private int dropBonus;
	
	public ChallengeDungeonStackedBonusMessage() {
	}
	
	public ChallengeDungeonStackedBonusMessage(int dungeonId, int xpBonus, int dropBonus) {
		this.dungeonId = dungeonId;
		this.xpBonus = xpBonus;
		this.dropBonus = dropBonus;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.dungeonId = reader.readInt();
		if (dungeonId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dungeonId = %s, it doesn't respect the following condition : dungeonId < 0", dungeonId));
		this.xpBonus = reader.readInt();
		if (xpBonus < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on xpBonus = %s, it doesn't respect the following condition : xpBonus < 0", xpBonus));
		this.dropBonus = reader.readInt();
		if (dropBonus < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dropBonus = %s, it doesn't respect the following condition : dropBonus < 0", dropBonus));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.dungeonId);
		writer.writeInt(this.xpBonus);
		writer.writeInt(this.dropBonus);
	}
}