package org.michocko.dofus2.protocol.messages.game.context.fight;

import org.michocko.dofus2.protocol.types.game.context.fight.FightTeamInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.fightId = reader.readShort();
		if (fightId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightId = %s, it doesn't respect the following condition : fightId < 0", fightId));
		this.team = new FightTeamInformations();
		this.team.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.fightId);
		this.team.serialize(writer);
	}
}