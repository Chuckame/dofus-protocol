package org.michocko.dofus2.protocol.types.game.character.alignment;

import org.michocko.dofus2.protocol.types.game.character.alignment.ActorAlignmentInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ActorExtendedAlignmentInformations extends ActorAlignmentInformations {
	public static final short TYPE_ID = 202;
	
	private int honor;
	private int honorGradeFloor;
	private int honorNextGradeFloor;
	private byte aggressable;
	
	public ActorExtendedAlignmentInformations() {
	}
	
	public ActorExtendedAlignmentInformations(byte alignmentSide, byte alignmentValue, byte alignmentGrade, int characterPower, int honor, int honorGradeFloor, int honorNextGradeFloor, byte aggressable) {
		super(alignmentSide, alignmentValue, alignmentGrade, characterPower);
		this.honor = honor;
		this.honorGradeFloor = honorGradeFloor;
		this.honorNextGradeFloor = honorNextGradeFloor;
		this.aggressable = aggressable;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.honor = reader.readUShort();
		if (honor < 0 || honor > 20000)
			throw new IllegalArgumentException(String.format("Forbidden value on honor = %s, it doesn't respect the following condition : honor < 0 || honor > 20000", honor));
		this.honorGradeFloor = reader.readUShort();
		if (honorGradeFloor < 0 || honorGradeFloor > 20000)
			throw new IllegalArgumentException(String.format("Forbidden value on honorGradeFloor = %s, it doesn't respect the following condition : honorGradeFloor < 0 || honorGradeFloor > 20000", honorGradeFloor));
		this.honorNextGradeFloor = reader.readUShort();
		if (honorNextGradeFloor < 0 || honorNextGradeFloor > 20000)
			throw new IllegalArgumentException(String.format("Forbidden value on honorNextGradeFloor = %s, it doesn't respect the following condition : honorNextGradeFloor < 0 || honorNextGradeFloor > 20000", honorNextGradeFloor));
		this.aggressable = reader.readSByte();
		if (aggressable < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on aggressable = %s, it doesn't respect the following condition : aggressable < 0", aggressable));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.honor);
		writer.writeUShort(this.honorGradeFloor);
		writer.writeUShort(this.honorNextGradeFloor);
		writer.writeSByte(this.aggressable);
	}
}