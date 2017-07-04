package org.michocko.dofus2.protocol.types.game.startup;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.ObjectItemInformationWithQuantity;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class StartupActionAddObject implements INetworkType {
	public static final short TYPE_ID = 52;
	
	private int uid;
	private String title;
	private String text;
	private String descUrl;
	private String pictureUrl;
	private Collection<ObjectItemInformationWithQuantity> items;
	
	public StartupActionAddObject() {
	}
	
	public StartupActionAddObject(int uid, String title, String text, String descUrl, String pictureUrl, Collection<ObjectItemInformationWithQuantity> items) {
		this.uid = uid;
		this.title = title;
		this.text = text;
		this.descUrl = descUrl;
		this.pictureUrl = pictureUrl;
		this.items = items;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.uid = reader.readInt();
		if (uid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on uid = %s, it doesn't respect the following condition : uid < 0", uid));
		this.title = reader.readUTF();
		this.text = reader.readUTF();
		this.descUrl = reader.readUTF();
		this.pictureUrl = reader.readUTF();
		int length = reader.readUShort();
		this.items = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItemInformationWithQuantity entry = new ObjectItemInformationWithQuantity();
			entry.deserialize(reader);
			this.items.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.uid);
		writer.writeUTF(this.title);
		writer.writeUTF(this.text);
		writer.writeUTF(this.descUrl);
		writer.writeUTF(this.pictureUrl);
		writer.writeUShort(this.items.size());
		for (ObjectItemInformationWithQuantity entry : this.items)
		{
			entry.serialize(writer);
		}
	}
}