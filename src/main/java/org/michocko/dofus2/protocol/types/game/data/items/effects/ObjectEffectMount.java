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
public class ObjectEffectMount extends ObjectEffect {
	public static final short TYPE_ID = 179;
	
	private int mountId;
	private double date;
	private short modelId;
	
	public ObjectEffectMount() {
	}
	
	public ObjectEffectMount(short actionId, int mountId, double date, short modelId) {
		super(actionId);
		this.mountId = mountId;
		this.date = date;
		this.modelId = modelId;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.mountId = reader.readInt();
		if (mountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on mountId = %s, it doesn't respect the following condition : mountId < 0", mountId));
		this.date = reader.readDouble();
		this.modelId = reader.readShort();
		if (modelId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on modelId = %s, it doesn't respect the following condition : modelId < 0", modelId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.mountId);
		writer.writeDouble(this.date);
		writer.writeShort(this.modelId);
	}
}