package org.chuckame.dofus2.protocol.messages.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.action.fight.FightDispellableEffectExtendedInformations;
import org.chuckame.dofus2.protocol.types.game.actions.fight.GameActionMark;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameFightSpectateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6069;
	
	private Collection<FightDispellableEffectExtendedInformations> effects;
	private Collection<GameActionMark> marks;
	private short gameTurn;
	
	public GameFightSpectateMessage() {
	}
	
	public GameFightSpectateMessage(Collection<FightDispellableEffectExtendedInformations> effects, Collection<GameActionMark> marks, short gameTurn) {
		this.effects = effects;
		this.marks = marks;
		this.gameTurn = gameTurn;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.effects = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			FightDispellableEffectExtendedInformations entry = new FightDispellableEffectExtendedInformations();
			entry.deserialize(reader);
			this.effects.add(entry);
		}
		length = reader.readUShort();
		this.marks = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GameActionMark entry = new GameActionMark();
			entry.deserialize(reader);
			this.marks.add(entry);
		}
		this.gameTurn = reader.readShort();
		if (gameTurn < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on gameTurn = %s, it doesn't respect the following condition : gameTurn < 0", gameTurn));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.effects.size());
		for (FightDispellableEffectExtendedInformations entry : this.effects)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.marks.size());
		for (GameActionMark entry : this.marks)
		{
			entry.serialize(writer);
		}
		writer.writeShort(this.gameTurn);
	}
}