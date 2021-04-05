package org.michocko.dofus2.protocol.messages.game.pvp;

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
public class UpdateMapPlayersAgressableStatusMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6454;
	
	private Collection<Integer> playerIds;
	private Collection<Byte> enable;
	
	public UpdateMapPlayersAgressableStatusMessage() {
	}
	
	public UpdateMapPlayersAgressableStatusMessage(Collection<Integer> playerIds, Collection<Byte> enable) {
		this.playerIds = playerIds;
		this.enable = enable;
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
		this.playerIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.playerIds.add(entry);
		}
		length = reader.readUShort();
		this.enable = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			byte entry = reader.readSByte();
			this.enable.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.playerIds.size());
		for (int entry : this.playerIds)
		{
			writer.writeInt(entry);
		}
		writer.writeUShort(this.enable.size());
		for (byte entry : this.enable)
		{
			writer.writeSByte(entry);
		}
	}
}