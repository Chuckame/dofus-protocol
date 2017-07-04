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
public class ObjectEffectString extends ObjectEffect {
	public static final short TYPE_ID = 74;
	
	private String value;
	
	public ObjectEffectString() {
	}
	
	public ObjectEffectString(short actionId, String value) {
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
		this.value = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.value);
	}
}