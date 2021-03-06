package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.mount.UpdateMountBoost;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class UpdateMountBoostMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6179;
	
	private double rideId;
	private Collection<UpdateMountBoost> boostToUpdateList;
	
	public UpdateMountBoostMessage() {
	}
	
	public UpdateMountBoostMessage(double rideId, Collection<UpdateMountBoost> boostToUpdateList) {
		this.rideId = rideId;
		this.boostToUpdateList = boostToUpdateList;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.rideId = reader.readDouble();
		int length = reader.readUShort();
		this.boostToUpdateList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			UpdateMountBoost entry = ProtocolTypeManager.getInstance().<UpdateMountBoost>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.boostToUpdateList.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.rideId);
		writer.writeUShort(this.boostToUpdateList.size());
		for (UpdateMountBoost entry : this.boostToUpdateList)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
	}
}