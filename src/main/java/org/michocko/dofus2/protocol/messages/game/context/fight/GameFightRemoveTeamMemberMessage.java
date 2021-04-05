package org.michocko.dofus2.protocol.messages.game.context.fight;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameFightRemoveTeamMemberMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 711;
	
	private short fightId;
	private byte teamId;
	private int charId;
	
	public GameFightRemoveTeamMemberMessage() {
	}
	
	public GameFightRemoveTeamMemberMessage(short fightId, byte teamId, int charId) {
		this.fightId = fightId;
		this.teamId = teamId;
		this.charId = charId;
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
		this.teamId = reader.readSByte();
		if (teamId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on teamId = %s, it doesn't respect the following condition : teamId < 0", teamId));
		this.charId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.fightId);
		writer.writeSByte(this.teamId);
		writer.writeInt(this.charId);
	}
}