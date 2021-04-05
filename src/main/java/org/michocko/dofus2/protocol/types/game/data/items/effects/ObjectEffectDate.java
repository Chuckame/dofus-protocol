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
public class ObjectEffectDate extends ObjectEffect {
	public static final short TYPE_ID = 72;
	
	private short year;
	private short month;
	private short day;
	private short hour;
	private short minute;
	
	public ObjectEffectDate() {
	}
	
	public ObjectEffectDate(short actionId, short year, short month, short day, short hour, short minute) {
		super(actionId);
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.year = reader.readShort();
		if (year < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on year = %s, it doesn't respect the following condition : year < 0", year));
		this.month = reader.readShort();
		if (month < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on month = %s, it doesn't respect the following condition : month < 0", month));
		this.day = reader.readShort();
		if (day < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on day = %s, it doesn't respect the following condition : day < 0", day));
		this.hour = reader.readShort();
		if (hour < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on hour = %s, it doesn't respect the following condition : hour < 0", hour));
		this.minute = reader.readShort();
		if (minute < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on minute = %s, it doesn't respect the following condition : minute < 0", minute));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.year);
		writer.writeShort(this.month);
		writer.writeShort(this.day);
		writer.writeShort(this.hour);
		writer.writeShort(this.minute);
	}
}