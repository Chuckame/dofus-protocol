package org.michocko.dofus2.protocol.messages.game.character.replay;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.messages.game.character.replay.CharacterReplayRequestMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class CharacterReplayWithRecolorRequestMessage extends CharacterReplayRequestMessage {
	public static final int MESSAGE_ID = 6111;
	
	private Collection<Integer> indexedColor;
	
	public CharacterReplayWithRecolorRequestMessage() {
	}
	
	public CharacterReplayWithRecolorRequestMessage(int characterId, Collection<Integer> indexedColor) {
		super(characterId);
		this.indexedColor = indexedColor;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.indexedColor = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.indexedColor.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.indexedColor.size());
		for (int entry : this.indexedColor)
		{
			writer.writeInt(entry);
		}
	}
}