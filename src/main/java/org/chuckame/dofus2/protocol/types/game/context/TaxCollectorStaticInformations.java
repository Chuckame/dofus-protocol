package org.chuckame.dofus2.protocol.types.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GuildInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class TaxCollectorStaticInformations implements INetworkType {
	public static final short TYPE_ID = 147;
	
	private short firstNameId;
	private short lastNameId;
	private GuildInformations guildIdentity;
	
	public TaxCollectorStaticInformations() {
	}
	
	public TaxCollectorStaticInformations(short firstNameId, short lastNameId, GuildInformations guildIdentity) {
		this.firstNameId = firstNameId;
		this.lastNameId = lastNameId;
		this.guildIdentity = guildIdentity;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.firstNameId = reader.readShort();
		if (firstNameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on firstNameId = %s, it doesn't respect the following condition : firstNameId < 0", firstNameId));
		this.lastNameId = reader.readShort();
		if (lastNameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lastNameId = %s, it doesn't respect the following condition : lastNameId < 0", lastNameId));
		this.guildIdentity = new GuildInformations();
		this.guildIdentity.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.firstNameId);
		writer.writeShort(this.lastNameId);
		this.guildIdentity.serialize(writer);
	}
}