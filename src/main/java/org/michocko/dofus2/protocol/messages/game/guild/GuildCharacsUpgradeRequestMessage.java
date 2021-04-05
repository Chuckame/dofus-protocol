package org.michocko.dofus2.protocol.messages.game.guild;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildCharacsUpgradeRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5706;
	
	private byte charaTypeTarget;
	
	public GuildCharacsUpgradeRequestMessage() {
	}
	
	public GuildCharacsUpgradeRequestMessage(byte charaTypeTarget) {
		this.charaTypeTarget = charaTypeTarget;
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
		this.charaTypeTarget = reader.readSByte();
		if (charaTypeTarget < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on charaTypeTarget = %s, it doesn't respect the following condition : charaTypeTarget < 0", charaTypeTarget));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.charaTypeTarget);
	}
}