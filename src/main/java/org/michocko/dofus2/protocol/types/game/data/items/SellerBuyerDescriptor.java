package org.michocko.dofus2.protocol.types.game.data.items;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class SellerBuyerDescriptor implements INetworkType {
	public static final short TYPE_ID = 121;
	
	private Collection<Integer> quantities;
	private Collection<Integer> types;
	private float taxPercentage;
	private float taxModificationPercentage;
	private int maxItemLevel;
	private int maxItemPerAccount;
	private int npcContextualId;
	private short unsoldDelay;
	
	public SellerBuyerDescriptor() {
	}
	
	public SellerBuyerDescriptor(Collection<Integer> quantities, Collection<Integer> types, float taxPercentage, float taxModificationPercentage, int maxItemLevel, int maxItemPerAccount, int npcContextualId, short unsoldDelay) {
		this.quantities = quantities;
		this.types = types;
		this.taxPercentage = taxPercentage;
		this.taxModificationPercentage = taxModificationPercentage;
		this.maxItemLevel = maxItemLevel;
		this.maxItemPerAccount = maxItemPerAccount;
		this.npcContextualId = npcContextualId;
		this.unsoldDelay = unsoldDelay;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.quantities = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.quantities.add(entry);
		}
		length = reader.readUShort();
		this.types = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.types.add(entry);
		}
		this.taxPercentage = reader.readFloat();
		this.taxModificationPercentage = reader.readFloat();
		this.maxItemLevel = reader.readInt();
		if (maxItemLevel < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxItemLevel = %s, it doesn't respect the following condition : maxItemLevel < 0", maxItemLevel));
		this.maxItemPerAccount = reader.readInt();
		if (maxItemPerAccount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxItemPerAccount = %s, it doesn't respect the following condition : maxItemPerAccount < 0", maxItemPerAccount));
		this.npcContextualId = reader.readInt();
		this.unsoldDelay = reader.readShort();
		if (unsoldDelay < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on unsoldDelay = %s, it doesn't respect the following condition : unsoldDelay < 0", unsoldDelay));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.quantities.size());
		for (int entry : this.quantities)
		{
			writer.writeInt(entry);
		}
		writer.writeUShort(this.types.size());
		for (int entry : this.types)
		{
			writer.writeInt(entry);
		}
		writer.writeFloat(this.taxPercentage);
		writer.writeFloat(this.taxModificationPercentage);
		writer.writeInt(this.maxItemLevel);
		writer.writeInt(this.maxItemPerAccount);
		writer.writeInt(this.npcContextualId);
		writer.writeShort(this.unsoldDelay);
	}
}