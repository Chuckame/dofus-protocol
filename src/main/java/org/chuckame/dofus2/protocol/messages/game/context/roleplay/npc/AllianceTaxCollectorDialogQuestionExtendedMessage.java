package org.chuckame.dofus2.protocol.messages.game.context.roleplay.npc;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.npc.TaxCollectorDialogQuestionExtendedMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicNamedAllianceInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class AllianceTaxCollectorDialogQuestionExtendedMessage extends TaxCollectorDialogQuestionExtendedMessage {
	public static final int MESSAGE_ID = 6445;
	
	private BasicNamedAllianceInformations alliance;
	
	public AllianceTaxCollectorDialogQuestionExtendedMessage() {
	}
	
	public AllianceTaxCollectorDialogQuestionExtendedMessage(BasicGuildInformations guildInfo, short maxPods, short prospecting, short wisdom, byte taxCollectorsCount, int taxCollectorAttack, int kamas, double experience, int pods, int itemsValue, BasicNamedAllianceInformations alliance) {
		super(guildInfo, maxPods, prospecting, wisdom, taxCollectorsCount, taxCollectorAttack, kamas, experience, pods, itemsValue);
		this.alliance = alliance;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.alliance = new BasicNamedAllianceInformations();
		this.alliance.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.alliance.serialize(writer);
	}
}