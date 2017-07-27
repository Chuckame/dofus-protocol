package org.chuckame.dofus2.protocol.messages.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightTeamInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameFightUpdateTeamMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5572;
	
	private short fightId;
	private FightTeamInformations team;
	
	public GameFightUpdateTeamMessage() {
	}
	
	public GameFightUpdateTeamMessage(short fightId, FightTeamInformations team) {
		this.fightId = fightId;
		this.team = team;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightId = reader.readShort();
		if (fightId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightId = %s, it doesn't respect the following condition : fightId < 0", fightId));
		this.team = new FightTeamInformations();
		this.team.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.fightId);
		this.team.serialize(writer);
	}
}