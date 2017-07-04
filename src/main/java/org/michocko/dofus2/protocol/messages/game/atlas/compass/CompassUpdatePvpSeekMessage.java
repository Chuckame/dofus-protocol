package org.michocko.dofus2.protocol.messages.game.atlas.compass;

import org.michocko.dofus2.protocol.types.game.context.MapCoordinates;
import org.michocko.dofus2.protocol.messages.game.atlas.compass.CompassUpdateMessage;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class CompassUpdatePvpSeekMessage extends CompassUpdateMessage {
	public static final int MESSAGE_ID = 6013;
	
	private int memberId;
	private String memberName;
	
	public CompassUpdatePvpSeekMessage() {
	}
	
	public CompassUpdatePvpSeekMessage(byte type, MapCoordinates coords, int memberId, String memberName) {
		super(type, coords);
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.memberId = reader.readInt();
		if (memberId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on memberId = %s, it doesn't respect the following condition : memberId < 0", memberId));
		this.memberName = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.memberId);
		writer.writeUTF(this.memberName);
	}
}