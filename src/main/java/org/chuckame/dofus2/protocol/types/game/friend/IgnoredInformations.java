package org.chuckame.dofus2.protocol.types.game.friend;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.friend.AbstractContactInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class IgnoredInformations extends AbstractContactInformations {
	public static final short TYPE_ID = 106;
	
	
	public IgnoredInformations() {
	}
	
	public IgnoredInformations(int accountId, String accountName) {
		super(accountId, accountName);
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
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