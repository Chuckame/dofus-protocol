package org.michocko.dofus2.protocol.types.game.prism;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.fight.ProtectedEntityWaitingForHelpInfo;
import org.michocko.dofus2.protocol.types.game.character.CharacterMinimalPlusLookInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class PrismFightersInformation implements INetworkType {
	public static final short TYPE_ID = 443;
	
	private short subAreaId;
	private ProtectedEntityWaitingForHelpInfo waitingForHelpInfo;
	private Collection<CharacterMinimalPlusLookInformations> allyCharactersInformations;
	private Collection<CharacterMinimalPlusLookInformations> enemyCharactersInformations;
	
	public PrismFightersInformation() {
	}
	
	public PrismFightersInformation(short subAreaId, ProtectedEntityWaitingForHelpInfo waitingForHelpInfo, Collection<CharacterMinimalPlusLookInformations> allyCharactersInformations, Collection<CharacterMinimalPlusLookInformations> enemyCharactersInformations) {
		this.subAreaId = subAreaId;
		this.waitingForHelpInfo = waitingForHelpInfo;
		this.allyCharactersInformations = allyCharactersInformations;
		this.enemyCharactersInformations = enemyCharactersInformations;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.waitingForHelpInfo = new ProtectedEntityWaitingForHelpInfo();
		this.waitingForHelpInfo.deserialize(reader);
		int length = reader.readUShort();
		this.allyCharactersInformations = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			CharacterMinimalPlusLookInformations entry = ProtocolTypeManager.getInstance().<CharacterMinimalPlusLookInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.allyCharactersInformations.add(entry);
		}
		length = reader.readUShort();
		this.enemyCharactersInformations = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			CharacterMinimalPlusLookInformations entry = ProtocolTypeManager.getInstance().<CharacterMinimalPlusLookInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.enemyCharactersInformations.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.subAreaId);
		this.waitingForHelpInfo.serialize(writer);
		writer.writeUShort(this.allyCharactersInformations.size());
		for (CharacterMinimalPlusLookInformations entry : this.allyCharactersInformations)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
		writer.writeUShort(this.enemyCharactersInformations.size());
		for (CharacterMinimalPlusLookInformations entry : this.enemyCharactersInformations)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}