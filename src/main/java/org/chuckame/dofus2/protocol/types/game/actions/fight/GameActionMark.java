package org.chuckame.dofus2.protocol.types.game.actions.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.protocol.types.game.actions.fight.GameActionMarkedCell;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class GameActionMark implements INetworkType {
	public static final short TYPE_ID = 351;
	
	private int markAuthorId;
	private int markSpellId;
	private short markId;
	private byte markType;
	private Collection<GameActionMarkedCell> cells;
	
	public GameActionMark() {
	}
	
	public GameActionMark(int markAuthorId, int markSpellId, short markId, byte markType, Collection<GameActionMarkedCell> cells) {
		this.markAuthorId = markAuthorId;
		this.markSpellId = markSpellId;
		this.markId = markId;
		this.markType = markType;
		this.cells = cells;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.markAuthorId = reader.readInt();
		this.markSpellId = reader.readInt();
		if (markSpellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on markSpellId = %s, it doesn't respect the following condition : markSpellId < 0", markSpellId));
		this.markId = reader.readShort();
		this.markType = reader.readSByte();
		int length = reader.readUShort();
		this.cells = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GameActionMarkedCell entry = new GameActionMarkedCell();
			entry.deserialize(reader);
			this.cells.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.markAuthorId);
		writer.writeInt(this.markSpellId);
		writer.writeShort(this.markId);
		writer.writeSByte(this.markType);
		writer.writeUShort(this.cells.size());
		for (GameActionMarkedCell entry : this.cells)
		{
			entry.serialize(writer);
		}
	}
}