package org.michocko.dofus2.protocol.messages.game.character.creation;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.enums.PlayableBreedEnum;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CharacterCreationRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 160;
	
	private String name;
	private PlayableBreedEnum breed;
	private boolean sex;
	private Collection<Integer> colors;
	private int cosmeticId;
	
	public CharacterCreationRequestMessage() {
	}
	
	public CharacterCreationRequestMessage(String name, PlayableBreedEnum breed, boolean sex, Collection<Integer> colors, int cosmeticId) {
		this.name = name;
		this.breed = breed;
		this.sex = sex;
		this.colors = colors;
		this.cosmeticId = cosmeticId;
	}
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.name = reader.readUTF();
		this.breed = PlayableBreedEnum.valueOf(reader.readSByte());
		if (this.breed != null)
			throw new IllegalArgumentException(String.format("Forbidden value on breed = %s, it doesn't respect the following condition : this.breed != null", breed));
		this.sex = reader.readBoolean();
		int length = reader.readUShort();
		this.colors = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.colors.add(entry);
		}
		this.cosmeticId = reader.readInt();
		if (cosmeticId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on cosmeticId = %s, it doesn't respect the following condition : cosmeticId < 0", cosmeticId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.name);
		writer.writeSByte((byte)this.breed.getValue());
		writer.writeBoolean(this.sex);
		writer.writeUShort(this.colors.size());
		for (int entry : this.colors)
		{
			writer.writeInt(entry);
		}
		writer.writeInt(this.cosmeticId);
	}
}