package org.chuckame.dofus2.protocol.messages.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.ShowCellMessage;

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
	public int getProtocolId() {
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