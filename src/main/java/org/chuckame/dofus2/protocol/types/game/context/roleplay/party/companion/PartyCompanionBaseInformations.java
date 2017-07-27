package org.chuckame.dofus2.protocol.types.game.context.roleplay.party.companion;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class PartyCompanionBaseInformations implements INetworkType {
	public static final short TYPE_ID = 453;
	
	private byte indexId;
	private short companionGenericId;
	private EntityLook entityLook;
	
	public PartyCompanionBaseInformations() {
	}
	
	public PartyCompanionBaseInformations(byte indexId, short companionGenericId, EntityLook entityLook) {
		this.indexId = indexId;
		this.companionGenericId = companionGenericId;
		this.entityLook = entityLook;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.indexId = reader.readSByte();
		if (indexId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on indexId = %s, it doesn't respect the following condition : indexId < 0", indexId));
		this.companionGenericId = reader.readShort();
		if (companionGenericId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on companionGenericId = %s, it doesn't respect the following condition : companionGenericId < 0", companionGenericId));
		this.entityLook = new EntityLook();
		this.entityLook.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.indexId);
		writer.writeShort(this.companionGenericId);
		this.entityLook.serialize(writer);
	}
}