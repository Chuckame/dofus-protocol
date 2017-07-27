package org.chuckame.dofus2.protocol.types.game.character.restriction;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

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
	
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
	}
	
	public void serialize(IDataWriter writer) {
	}
}