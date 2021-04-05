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
public class ObjectEffectMinMax extends ObjectEffect {
	public static final short TYPE_ID = 82;
	
	private short min;
	private short max;
	
	public ObjectEffectMinMax() {
	}
	
	public ObjectEffectMinMax(short actionId, short min, short max) {
		super(actionId);
		this.min = min;
		this.max = max;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.min = reader.readShort();
		if (min < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on min = %s, it doesn't respect the following condition : min < 0", min));
		this.max = reader.readShort();
		if (max < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on max = %s, it doesn't respect the following condition : max < 0", max));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.min);
		writer.writeShort(this.max);
	}
}