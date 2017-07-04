package org.michocko.dofus2.protocol.types.game.character.restriction;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class ActorRestrictionsInformations implements INetworkType {
	public static final short TYPE_ID = 204;
	
	
	public ActorRestrictionsInformations() {
	}
	
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
	}
	
	public void serialize(IDataWriter writer) {
	}
}