package org.michocko.dofus2.protocol.types.game.data.items.effects;

import org.michocko.dofus2.protocol.types.game.data.items.effects.ObjectEffect;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ObjectEffectDice extends ObjectEffect {
	public static final short TYPE_ID = 73;
	
	private short diceNum;
	private short diceSide;
	private short diceConst;
	
	public ObjectEffectDice() {
	}
	
	public ObjectEffectDice(short actionId, short diceNum, short diceSide, short diceConst) {
		super(actionId);
		this.diceNum = diceNum;
		this.diceSide = diceSide;
		this.diceConst = diceConst;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.diceNum = reader.readShort();
		if (diceNum < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on diceNum = %s, it doesn't respect the following condition : diceNum < 0", diceNum));
		this.diceSide = reader.readShort();
		if (diceSide < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on diceSide = %s, it doesn't respect the following condition : diceSide < 0", diceSide));
		this.diceConst = reader.readShort();
		if (diceConst < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on diceConst = %s, it doesn't respect the following condition : diceConst < 0", diceConst));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.diceNum);
		writer.writeShort(this.diceSide);
		writer.writeShort(this.diceConst);
	}
}