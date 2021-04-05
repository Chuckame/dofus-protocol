package org.michocko.dofus2.protocol.types.game.paddock;

import org.michocko.dofus2.protocol.types.game.mount.ItemDurability;
import org.michocko.dofus2.protocol.types.game.context.roleplay.ObjectItemInRolePlay;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class PaddockItem extends ObjectItemInRolePlay {
	public static final short TYPE_ID = 185;
	
	private ItemDurability durability;
	
	public PaddockItem() {
	}
	
	public PaddockItem(short cellId, short objectGID, ItemDurability durability) {
		super(cellId, objectGID);
		this.durability = durability;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.durability = new ItemDurability();
		this.durability.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.durability.serialize(writer);
	}
}