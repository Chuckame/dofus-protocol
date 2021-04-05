package org.michocko.dofus2.protocol.types.game.actions.fight;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class AbstractFightDispellableEffect implements INetworkType {
	public static final short TYPE_ID = 206;
	
	private int uid;
	private int targetId;
	private short turnDuration;
	private byte dispelable;
	private short spellId;
	private int parentBoostUid;
	
	public AbstractFightDispellableEffect() {
	}
	
	public AbstractFightDispellableEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid) {
		this.uid = uid;
		this.targetId = targetId;
		this.turnDuration = turnDuration;
		this.dispelable = dispelable;
		this.spellId = spellId;
		this.parentBoostUid = parentBoostUid;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.uid = reader.readInt();
		if (uid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on uid = %s, it doesn't respect the following condition : uid < 0", uid));
		this.targetId = reader.readInt();
		this.turnDuration = reader.readShort();
		this.dispelable = reader.readSByte();
		if (dispelable < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dispelable = %s, it doesn't respect the following condition : dispelable < 0", dispelable));
		this.spellId = reader.readShort();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
		this.parentBoostUid = reader.readInt();
		if (parentBoostUid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on parentBoostUid = %s, it doesn't respect the following condition : parentBoostUid < 0", parentBoostUid));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.uid);
		writer.writeInt(this.targetId);
		writer.writeShort(this.turnDuration);
		writer.writeSByte(this.dispelable);
		writer.writeShort(this.spellId);
		writer.writeInt(this.parentBoostUid);
	}
}