package org.michocko.dofus2.protocol.messages.game.context.roleplay.spell;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SpellForgottenMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5834;
	
	private Collection<Short> spellsId;
	private short boostPoint;
	
	public SpellForgottenMessage() {
	}
	
	public SpellForgottenMessage(Collection<Short> spellsId, short boostPoint) {
		this.spellsId = spellsId;
		this.boostPoint = boostPoint;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.spellsId = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.spellsId.add(entry);
		}
		this.boostPoint = reader.readShort();
		if (boostPoint < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on boostPoint = %s, it doesn't respect the following condition : boostPoint < 0", boostPoint));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.spellsId.size());
		for (short entry : this.spellsId)
		{
			writer.writeShort(entry);
		}
		writer.writeShort(this.boostPoint);
	}
}