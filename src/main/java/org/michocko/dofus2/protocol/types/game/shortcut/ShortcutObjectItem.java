package org.michocko.dofus2.protocol.types.game.shortcut;

import org.michocko.dofus2.protocol.types.game.shortcut.ShortcutObject;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ShortcutObjectItem extends ShortcutObject {
	public static final short TYPE_ID = 371;
	
	private int itemUID;
	private int itemGID;
	
	public ShortcutObjectItem() {
	}
	
	public ShortcutObjectItem(int slot, int itemUID, int itemGID) {
		super(slot);
		this.itemUID = itemUID;
		this.itemGID = itemGID;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.itemUID = reader.readInt();
		this.itemGID = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.itemUID);
		writer.writeInt(this.itemGID);
	}
}