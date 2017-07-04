package org.michocko.dofus2.protocol.messages.game.actions.fight;

import org.michocko.dofus2.protocol.types.game.context.fight.GameFightFighterInformations;
import org.michocko.dofus2.protocol.messages.game.actions.AbstractGameActionMessage;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightSummonMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5825;
	
	private GameFightFighterInformations summon;
	
	public GameActionFightSummonMessage() {
	}
	
	public GameActionFightSummonMessage(short actionId, int sourceId, GameFightFighterInformations summon) {
		super(actionId, sourceId);
		this.summon = summon;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.summon = ProtocolTypeManager.getInstance().<GameFightFighterInformations>newInstance(reader.readShort());
		this.summon.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.summon.getNetworkTypeId());
		this.summon.serialize(writer);
	}
}