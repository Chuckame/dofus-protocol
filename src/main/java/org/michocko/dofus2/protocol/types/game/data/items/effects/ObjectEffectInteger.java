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
public class ObjectEffectInteger extends ObjectEffect {
	public static final short TYPE_ID = 70;
	
	private short value;
	
	public ObjectEffectInteger() {
	}
	
	public ObjectEffectInteger(short actionId, short value) {
		super(actionId);
		this.value = value;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.value = reader.readShort();
		if (value < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on value = %s, it doesn't respect the following condition : value < 0", value));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.value);
	}
}