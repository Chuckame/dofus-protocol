package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.inventory.exchanges.ExchangeStartOkCraftMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeStartOkCraftWithInformationMessage extends ExchangeStartOkCraftMessage {
	public static final int MESSAGE_ID = 5941;
	
	private byte nbCase;
	private int skillId;
	
	public ExchangeStartOkCraftWithInformationMessage() {
	}
	
	public ExchangeStartOkCraftWithInformationMessage(byte nbCase, int skillId) {
		this.nbCase = nbCase;
		this.skillId = skillId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.nbCase = reader.readSByte();
		if (nbCase < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbCase = %s, it doesn't respect the following condition : nbCase < 0", nbCase));
		this.skillId = reader.readInt();
		if (skillId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skillId = %s, it doesn't respect the following condition : skillId < 0", skillId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.nbCase);
		writer.writeInt(this.skillId);
	}
}