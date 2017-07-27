package org.chuckame.dofus2.protocol.types.game.context.roleplay.party;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.character.choice.CharacterBaseInformations;
import org.chuckame.dofus2.protocol.types.game.character.status.PlayerStatus;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.party.companion.PartyCompanionMemberInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class PartyMemberInformations extends CharacterBaseInformations {
	public static final short TYPE_ID = 90;
	
	private int lifePoints;
	private int maxLifePoints;
	private short prospecting;
	private short regenRate;
	private short initiative;
	private byte alignmentSide;
	private short worldX;
	private short worldY;
	private int mapId;
	private short subAreaId;
	private PlayerStatus status;
	private Collection<PartyCompanionMemberInformations> companions;
	
	public PartyMemberInformations() {
	}
	
	public PartyMemberInformations(int id, short level, String name, EntityLook entityLook, byte breed, boolean sex, int lifePoints, int maxLifePoints, short prospecting, short regenRate, short initiative, byte alignmentSide, short worldX, short worldY, int mapId, short subAreaId, PlayerStatus status, Collection<PartyCompanionMemberInformations> companions) {
		super(id, level, name, entityLook, breed, sex);
		this.lifePoints = lifePoints;
		this.maxLifePoints = maxLifePoints;
		this.prospecting = prospecting;
		this.regenRate = regenRate;
		this.initiative = initiative;
		this.alignmentSide = alignmentSide;
		this.worldX = worldX;
		this.worldY = worldY;
		this.mapId = mapId;
		this.subAreaId = subAreaId;
		this.status = status;
		this.companions = companions;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.lifePoints = reader.readInt();
		if (lifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lifePoints = %s, it doesn't respect the following condition : lifePoints < 0", lifePoints));
		this.maxLifePoints = reader.readInt();
		if (maxLifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxLifePoints = %s, it doesn't respect the following condition : maxLifePoints < 0", maxLifePoints));
		this.prospecting = reader.readShort();
		if (prospecting < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on prospecting = %s, it doesn't respect the following condition : prospecting < 0", prospecting));
		this.regenRate = reader.readByte();
		if (regenRate < 0 || regenRate > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on regenRate = %s, it doesn't respect the following condition : regenRate < 0 || regenRate > 255", regenRate));
		this.initiative = reader.readShort();
		if (initiative < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on initiative = %s, it doesn't respect the following condition : initiative < 0", initiative));
		this.alignmentSide = reader.readSByte();
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
		this.status = ProtocolTypeManager.getInstance().<PlayerStatus>newInstance(reader.readShort());
		this.status.deserialize(reader);
		int length = reader.readUShort();
		this.companions = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PartyCompanionMemberInformations entry = new PartyCompanionMemberInformations();
			entry.deserialize(reader);
			this.companions.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.lifePoints);
		writer.writeInt(this.maxLifePoints);
		writer.writeShort(this.prospecting);
		writer.writeByte(this.regenRate);
		writer.writeShort(this.initiative);
		writer.writeSByte(this.alignmentSide);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeInt(this.mapId);
		writer.writeShort(this.subAreaId);
		writer.writeShort(this.status.getProtocolTypeId());
		this.status.serialize(writer);
		writer.writeUShort(this.companions.size());
		for (PartyCompanionMemberInformations entry : this.companions)
		{
			entry.serialize(writer);
		}
	}
}