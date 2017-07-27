package org.chuckame.dofus2.protocol.types.game.guild.tax;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.character.CharacterMinimalPlusLookInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class TaxCollectorFightersInformation implements INetworkType {
	public static final short TYPE_ID = 169;
	
	private int collectorId;
	private Collection<CharacterMinimalPlusLookInformations> allyCharactersInformations;
	private Collection<CharacterMinimalPlusLookInformations> enemyCharactersInformations;
	
	public TaxCollectorFightersInformation() {
	}
	
	public TaxCollectorFightersInformation(int collectorId, Collection<CharacterMinimalPlusLookInformations> allyCharactersInformations, Collection<CharacterMinimalPlusLookInformations> enemyCharactersInformations) {
		this.collectorId = collectorId;
		this.allyCharactersInformations = allyCharactersInformations;
		this.enemyCharactersInformations = enemyCharactersInformations;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.collectorId = reader.readInt();
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
		writer.writeInt(this.collectorId);
		writer.writeUShort(this.allyCharactersInformations.size());
		for (CharacterMinimalPlusLookInformations entry : this.allyCharactersInformations)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
		writer.writeUShort(this.enemyCharactersInformations.size());
		for (CharacterMinimalPlusLookInformations entry : this.enemyCharactersInformations)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
	}
}