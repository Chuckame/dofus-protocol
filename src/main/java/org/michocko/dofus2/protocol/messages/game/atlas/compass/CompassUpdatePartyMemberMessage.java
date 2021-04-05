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
public class CompassUpdatePartyMemberMessage extends CompassUpdateMessage {
	public static final int MESSAGE_ID = 5589;
	
	private int memberId;
	
	public CompassUpdatePartyMemberMessage() {
	}
	
	public CompassUpdatePartyMemberMessage(byte type, MapCoordinates coords, int memberId) {
		super(type, coords);
		this.memberId = memberId;
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
		super.deserialize(reader);
		this.memberId = reader.readInt();
		if (memberId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on memberId = %s, it doesn't respect the following condition : memberId < 0", memberId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.memberId);
	}
}