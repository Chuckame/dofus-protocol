package org.michocko.dofus2.protocol.messages.game.context;

import org.michocko.dofus2.protocol.messages.game.context.ShowCellMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ShowCellSpectatorMessage extends ShowCellMessage {
	public static final int MESSAGE_ID = 6158;
	
	private String playerName;
	
	public ShowCellSpectatorMessage() {
	}
	
	public ShowCellSpectatorMessage(int sourceId, short cellId, String playerName) {
		super(sourceId, cellId);
		this.playerName = playerName;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.playerName = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.playerName);
	}
}