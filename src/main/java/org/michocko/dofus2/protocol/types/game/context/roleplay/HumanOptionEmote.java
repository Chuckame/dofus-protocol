package org.michocko.dofus2.protocol.types.game.context.roleplay;

import org.michocko.dofus2.protocol.types.game.context.roleplay.HumanOption;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class HumanOptionEmote extends HumanOption {
	public static final short TYPE_ID = 407;
	
	private short emoteId;
	private double emoteStartTime;
	
	public HumanOptionEmote() {
	}
	
	public HumanOptionEmote(short emoteId, double emoteStartTime) {
		this.emoteId = emoteId;
		this.emoteStartTime = emoteStartTime;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.emoteId = reader.readByte();
		if (emoteId < 0 || emoteId > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on emoteId = %s, it doesn't respect the following condition : emoteId < 0 || emoteId > 255", emoteId));
		this.emoteStartTime = reader.readDouble();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeByte(this.emoteId);
		writer.writeDouble(this.emoteStartTime);
	}
}