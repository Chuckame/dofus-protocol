package org.michocko.dofus2.protocol.messages.game.alliance;

import org.michocko.dofus2.protocol.types.game.context.roleplay.AllianceInformations;
import org.michocko.dofus2.protocol.messages.game.alliance.AllianceJoinedMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	public int getNetworkMessageId() {
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