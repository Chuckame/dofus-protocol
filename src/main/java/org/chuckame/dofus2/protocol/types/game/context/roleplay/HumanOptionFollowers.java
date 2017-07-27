package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.HumanOption;
import org.chuckame.dofus2.protocol.types.game.look.IndexedEntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class HumanOptionFollowers extends HumanOption {
	public static final short TYPE_ID = 410;
	
	private Collection<IndexedEntityLook> followingCharactersLook;
	
	public HumanOptionFollowers() {
	}
	
	public HumanOptionFollowers(Collection<IndexedEntityLook> followingCharactersLook) {
		this.followingCharactersLook = followingCharactersLook;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.followingCharactersLook = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			IndexedEntityLook entry = new IndexedEntityLook();
			entry.deserialize(reader);
			this.followingCharactersLook.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.followingCharactersLook.size());
		for (IndexedEntityLook entry : this.followingCharactersLook)
		{
			entry.serialize(writer);
		}
	}
}