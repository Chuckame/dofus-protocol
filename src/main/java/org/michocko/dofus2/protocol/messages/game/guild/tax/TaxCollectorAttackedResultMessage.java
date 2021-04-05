package org.michocko.dofus2.protocol.messages.game.guild.tax;

import org.michocko.dofus2.protocol.types.game.guild.tax.TaxCollectorBasicInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TaxCollectorAttackedResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5635;
	
	private boolean deadOrAlive;
	private TaxCollectorBasicInformations basicInfos;
	private BasicGuildInformations guild;
	
	public TaxCollectorAttackedResultMessage() {
	}
	
	public TaxCollectorAttackedResultMessage(boolean deadOrAlive, TaxCollectorBasicInformations basicInfos, BasicGuildInformations guild) {
		this.deadOrAlive = deadOrAlive;
		this.basicInfos = basicInfos;
		this.guild = guild;
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
		this.deadOrAlive = reader.readBoolean();
		this.basicInfos = new TaxCollectorBasicInformations();
		this.basicInfos.deserialize(reader);
		this.guild = new BasicGuildInformations();
		this.guild.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.deadOrAlive);
		this.basicInfos.serialize(writer);
		this.guild.serialize(writer);
	}
}