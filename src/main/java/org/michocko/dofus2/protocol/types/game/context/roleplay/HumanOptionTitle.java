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
public class HumanOptionTitle extends HumanOption {
	public static final short TYPE_ID = 408;
	
	private short titleId;
	private String titleParam;
	
	public HumanOptionTitle() {
	}
	
	public HumanOptionTitle(short titleId, String titleParam) {
		this.titleId = titleId;
		this.titleParam = titleParam;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.titleId = reader.readShort();
		if (titleId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on titleId = %s, it doesn't respect the following condition : titleId < 0", titleId));
		this.titleParam = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.titleId);
		writer.writeUTF(this.titleParam);
	}
}