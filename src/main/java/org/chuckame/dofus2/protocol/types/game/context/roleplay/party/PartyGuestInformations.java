package org.chuckame.dofus2.protocol.types.game.context.roleplay.party;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.character.status.PlayerStatus;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.party.companion.PartyCompanionBaseInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class PartyGuestInformations implements INetworkType {
	public static final short TYPE_ID = 374;
	
	private int guestId;
	private int hostId;
	private String name;
	private EntityLook guestLook;
	private byte breed;
	private boolean sex;
	private PlayerStatus status;
	private Collection<PartyCompanionBaseInformations> companions;
	
	public PartyGuestInformations() {
	}
	
	public PartyGuestInformations(int guestId, int hostId, String name, EntityLook guestLook, byte breed, boolean sex, PlayerStatus status, Collection<PartyCompanionBaseInformations> companions) {
		this.guestId = guestId;
		this.hostId = hostId;
		this.name = name;
		this.guestLook = guestLook;
		this.breed = breed;
		this.sex = sex;
		this.status = status;
		this.companions = companions;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.guestId = reader.readInt();
		if (guestId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on guestId = %s, it doesn't respect the following condition : guestId < 0", guestId));
		this.hostId = reader.readInt();
		if (hostId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on hostId = %s, it doesn't respect the following condition : hostId < 0", hostId));
		this.name = reader.readUTF();
		this.guestLook = new EntityLook();
		this.guestLook.deserialize(reader);
		this.breed = reader.readSByte();
		this.sex = reader.readBoolean();
		this.status = ProtocolTypeManager.getInstance().<PlayerStatus>newInstance(reader.readShort());
		this.status.deserialize(reader);
		int length = reader.readUShort();
		this.companions = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PartyCompanionBaseInformations entry = new PartyCompanionBaseInformations();
			entry.deserialize(reader);
			this.companions.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.guestId);
		writer.writeInt(this.hostId);
		writer.writeUTF(this.name);
		this.guestLook.serialize(writer);
		writer.writeSByte(this.breed);
		writer.writeBoolean(this.sex);
		writer.writeShort(this.status.getProtocolTypeId());
		this.status.serialize(writer);
		writer.writeUShort(this.companions.size());
		for (PartyCompanionBaseInformations entry : this.companions)
		{
			entry.serialize(writer);
		}
	}
}