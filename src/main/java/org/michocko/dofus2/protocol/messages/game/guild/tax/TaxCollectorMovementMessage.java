package org.michocko.dofus2.protocol.messages.game.guild.tax;

import org.michocko.dofus2.protocol.types.game.guild.tax.TaxCollectorBasicInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TaxCollectorMovementMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5633;
	
	private boolean hireOrFire;
	private TaxCollectorBasicInformations basicInfos;
	private int playerId;
	private String playerName;
	
	public TaxCollectorMovementMessage() {
	}
	
	public TaxCollectorMovementMessage(boolean hireOrFire, TaxCollectorBasicInformations basicInfos, int playerId, String playerName) {
		this.hireOrFire = hireOrFire;
		this.basicInfos = basicInfos;
		this.playerId = playerId;
		this.playerName = playerName;
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
		this.hireOrFire = reader.readBoolean();
		this.basicInfos = new TaxCollectorBasicInformations();
		this.basicInfos.deserialize(reader);
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		this.playerName = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.hireOrFire);
		this.basicInfos.serialize(writer);
		writer.writeInt(this.playerId);
		writer.writeUTF(this.playerName);
	}
}