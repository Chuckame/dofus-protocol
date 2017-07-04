package org.michocko.dofus2.protocol.messages.web.krosmaster;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.web.krosmaster.KrosmasterFigure;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class KrosmasterInventoryMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6350;
	
	private Collection<KrosmasterFigure> figures;
	
	public KrosmasterInventoryMessage() {
	}
	
	public KrosmasterInventoryMessage(Collection<KrosmasterFigure> figures) {
		this.figures = figures;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.figures = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			KrosmasterFigure entry = new KrosmasterFigure();
			entry.deserialize(reader);
			this.figures.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.figures.size());
		for (KrosmasterFigure entry : this.figures)
		{
			entry.serialize(writer);
		}
	}
}