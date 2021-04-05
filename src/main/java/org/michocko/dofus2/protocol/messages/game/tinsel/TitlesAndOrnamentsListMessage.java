package org.michocko.dofus2.protocol.messages.game.tinsel;

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
public class TitlesAndOrnamentsListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6367;
	
	private Collection<Short> titles;
	private Collection<Short> ornaments;
	private short activeTitle;
	private short activeOrnament;
	
	public TitlesAndOrnamentsListMessage() {
	}
	
	public TitlesAndOrnamentsListMessage(Collection<Short> titles, Collection<Short> ornaments, short activeTitle, short activeOrnament) {
		this.titles = titles;
		this.ornaments = ornaments;
		this.activeTitle = activeTitle;
		this.activeOrnament = activeOrnament;
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
		int length = reader.readUShort();
		this.titles = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.titles.add(entry);
		}
		length = reader.readUShort();
		this.ornaments = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.ornaments.add(entry);
		}
		this.activeTitle = reader.readShort();
		if (activeTitle < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on activeTitle = %s, it doesn't respect the following condition : activeTitle < 0", activeTitle));
		this.activeOrnament = reader.readShort();
		if (activeOrnament < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on activeOrnament = %s, it doesn't respect the following condition : activeOrnament < 0", activeOrnament));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.titles.size());
		for (short entry : this.titles)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.ornaments.size());
		for (short entry : this.ornaments)
		{
			writer.writeShort(entry);
		}
		writer.writeShort(this.activeTitle);
		writer.writeShort(this.activeOrnament);
	}
}