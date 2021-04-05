package org.michocko.dofus2.protocol.messages.game.context.roleplay.paddock;

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
public class GameDataPlayFarmObjectAnimationMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6026;
	
	private Collection<Short> cellId;
	
	public GameDataPlayFarmObjectAnimationMessage() {
	}
	
	public GameDataPlayFarmObjectAnimationMessage(Collection<Short> cellId) {
		this.cellId = cellId;
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
		this.cellId = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.cellId.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.cellId.size());
		for (short entry : this.cellId)
		{
			writer.writeShort(entry);
		}
	}
}