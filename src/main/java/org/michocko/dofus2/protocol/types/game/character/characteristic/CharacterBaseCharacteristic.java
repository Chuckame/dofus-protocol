package org.michocko.dofus2.protocol.types.game.character.characteristic;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class CharacterBaseCharacteristic implements INetworkType {
	public static final short TYPE_ID = 4;
	
	private short base;
	private short objectsAndMountBonus;
	private short alignGiftBonus;
	private short contextModif;
	
	public CharacterBaseCharacteristic() {
	}
	
	public CharacterBaseCharacteristic(short base, short objectsAndMountBonus, short alignGiftBonus, short contextModif) {
		this.base = base;
		this.objectsAndMountBonus = objectsAndMountBonus;
		this.alignGiftBonus = alignGiftBonus;
		this.contextModif = contextModif;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.base = reader.readShort();
		this.objectsAndMountBonus = reader.readShort();
		this.alignGiftBonus = reader.readShort();
		this.contextModif = reader.readShort();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.base);
		writer.writeShort(this.objectsAndMountBonus);
		writer.writeShort(this.alignGiftBonus);
		writer.writeShort(this.contextModif);
	}
}