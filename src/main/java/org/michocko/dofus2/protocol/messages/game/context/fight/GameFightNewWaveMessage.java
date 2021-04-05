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
public class GameFightNewWaveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6490;
	
	private long id;
	private int teamId;
	private int nbTurnBeforeNextWave;
	
	public GameFightNewWaveMessage() {
	}
	
	public GameFightNewWaveMessage(long id, int teamId, int nbTurnBeforeNextWave) {
		this.id = id;
		this.teamId = teamId;
		this.nbTurnBeforeNextWave = nbTurnBeforeNextWave;
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
		this.id = reader.readUInt();
		if (id < 0 || id > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0 || id > 4.294967295E9", id));
		this.teamId = reader.readInt();
		this.nbTurnBeforeNextWave = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUInt(this.id);
		writer.writeInt(this.teamId);
		writer.writeInt(this.nbTurnBeforeNextWave);
	}
}