package org.chuckame.dofus2.protocol.messages.game.alliance;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.alliance.AllianceJoinedMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.AllianceInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class AllianceMembershipMessage extends AllianceJoinedMessage {
	public static final int MESSAGE_ID = 6390;
	
	
	public AllianceMembershipMessage() {
	}
	
	public AllianceMembershipMessage(AllianceInformations allianceInfo, boolean enabled) {
		super(allianceInfo, enabled);
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}