package org.chuckame.dofus2.protocol.types.game.shortcut;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.shortcut.ShortcutObject;

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
	public short getProtocolTypeId() {
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