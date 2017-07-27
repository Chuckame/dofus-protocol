package org.chuckame.dofus2.protocol.types.game.character.alignment;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class ActorAlignmentInformations implements INetworkType {
	public static final short TYPE_ID = 201;
	
	private byte alignmentSide;
	private byte alignmentValue;
	private byte alignmentGrade;
	private int characterPower;
	
	public ActorAlignmentInformations() {
	}
	
	public ActorAlignmentInformations(byte alignmentSide, byte alignmentValue, byte alignmentGrade, int characterPower) {
		this.alignmentSide = alignmentSide;
		this.alignmentValue = alignmentValue;
		this.alignmentGrade = alignmentGrade;
		this.characterPower = characterPower;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.alignmentSide = reader.readSByte();
		this.alignmentValue = reader.readSByte();
		if (alignmentValue < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on alignmentValue = %s, it doesn't respect the following condition : alignmentValue < 0", alignmentValue));
		this.alignmentGrade = reader.readSByte();
		if (alignmentGrade < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on alignmentGrade = %s, it doesn't respect the following condition : alignmentGrade < 0", alignmentGrade));
		this.characterPower = reader.readInt();
		if (characterPower < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on characterPower = %s, it doesn't respect the following condition : characterPower < 0", characterPower));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.alignmentSide);
		writer.writeSByte(this.alignmentValue);
		writer.writeSByte(this.alignmentGrade);
		writer.writeInt(this.characterPower);
	}
}