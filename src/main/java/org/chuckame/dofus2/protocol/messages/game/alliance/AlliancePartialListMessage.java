package org.chuckame.dofus2.protocol.messages.game.alliance;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.alliance.AllianceListMessage;
import org.chuckame.dofus2.protocol.types.game.social.AllianceFactSheetInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class AlliancePartialListMessage extends AllianceListMessage {
	public static final int MESSAGE_ID = 6427;
	
	
	public AlliancePartialListMessage() {
	}
	
	public AlliancePartialListMessage(Collection<AllianceFactSheetInformations> alliances) {
		super(alliances);
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