package org.chuckame.dofus2.protocol.messages.game.actions.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.actions.fight.GameActionFightDispellMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightDispellEffectMessage extends GameActionFightDispellMessage {
	public static final int MESSAGE_ID = 6113;
	
	private int boostUID;
	
	public GameActionFightDispellEffectMessage() {
	}
	
	public GameActionFightDispellEffectMessage(short actionId, int sourceId, int targetId, int boostUID) {
		super(actionId, sourceId, targetId);
		this.boostUID = boostUID;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.boostUID = reader.readInt();
		if (boostUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on boostUID = %s, it doesn't respect the following condition : boostUID < 0", boostUID));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.boostUID);
	}
}