package org.michocko.dofus2.protocol.types.game.guild.tax;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class AdditionalTaxCollectorInformations implements INetworkType {
	public static final short TYPE_ID = 165;
	
	private String collectorCallerName;
	private int date;
	
	public AdditionalTaxCollectorInformations() {
	}
	
	public AdditionalTaxCollectorInformations(String collectorCallerName, int date) {
		this.collectorCallerName = collectorCallerName;
		this.date = date;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.collectorCallerName = reader.readUTF();
		this.date = reader.readInt();
		if (date < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on date = %s, it doesn't respect the following condition : date < 0", date));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.collectorCallerName);
		writer.writeInt(this.date);
	}
}