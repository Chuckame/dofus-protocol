package org.michocko.dofus2.protocol.types.game.context.roleplay.party;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.party.companion.PartyCompanionBaseInformations;
import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.character.choice.CharacterBaseInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class PartyInvitationMemberInformations extends CharacterBaseInformations {
	public static final short TYPE_ID = 376;
	
	private short worldX;
	private short worldY;
	private int mapId;
	private short subAreaId;
	private Collection<PartyCompanionBaseInformations> companions;
	
	public PartyInvitationMemberInformations() {
	}
	
	public PartyInvitationMemberInformations(int id, short level, String name, EntityLook entityLook, byte breed, boolean sex, short worldX, short worldY, int mapId, short subAreaId, Collection<PartyCompanionBaseInformations> companions) {
		super(id, level, name, entityLook, breed, sex);
		this.worldX = worldX;
		this.worldY = worldY;
		this.mapId = mapId;
		this.subAreaId = subAreaId;
		this.companions = companions;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.worldX = reader.readShort();
		if (worldX < -255 || worldX > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldX = %s, it doesn't respect the following condition : worldX < -255 || worldX > 255", worldX));
		this.worldY = reader.readShort();
		if (worldY < -255 || worldY > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldY = %s, it doesn't respect the following condition : worldY < -255 || worldY > 255", worldY));
		this.mapId = reader.readInt();
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		int length = reader.readUShort();
		this.companions = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PartyCompanionBaseInformations entry = new PartyCompanionBaseInformations();
			entry.deserialize(reader);
			this.companions.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeInt(this.mapId);
		writer.writeShort(this.subAreaId);
		writer.writeUShort(this.companions.size());
		for (PartyCompanionBaseInformations entry : this.companions)
		{
			entry.serialize(writer);
		}
	}
}