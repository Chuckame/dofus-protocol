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
public class ObjectEffectDuration extends ObjectEffect {
	public static final short TYPE_ID = 75;
	
	private short days;
	private short hours;
	private short minutes;
	
	public ObjectEffectDuration() {
	}
	
	public ObjectEffectDuration(short actionId, short days, short hours, short minutes) {
		super(actionId);
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.days = reader.readShort();
		if (days < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on days = %s, it doesn't respect the following condition : days < 0", days));
		this.hours = reader.readShort();
		if (hours < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on hours = %s, it doesn't respect the following condition : hours < 0", hours));
		this.minutes = reader.readShort();
		if (minutes < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on minutes = %s, it doesn't respect the following condition : minutes < 0", minutes));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.days);
		writer.writeShort(this.hours);
		writer.writeShort(this.minutes);
	}
}