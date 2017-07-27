package org.chuckame.dofus2.protocol.messages.game.guild.tax;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;
import org.chuckame.dofus2.protocol.types.game.guild.tax.TaxCollectorBasicInformations;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.deadOrAlive = reader.readBoolean();
		this.basicInfos = new TaxCollectorBasicInformations();
		this.basicInfos.deserialize(reader);
		this.guild = new BasicGuildInformations();
		this.guild.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.deadOrAlive);
		this.basicInfos.serialize(writer);
		this.guild.serialize(writer);
	}
}