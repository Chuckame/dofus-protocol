package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AlignmentSideEnum {
	ALIGNMENT_UNKNOWN(-2),
	ALIGNMENT_WITHOUT(-1),
	ALIGNMENT_NEUTRAL(0),
	ALIGNMENT_ANGEL(1),
	ALIGNMENT_EVIL(2),
	ALIGNMENT_MERCENARY(3);
	
	@Getter
	private final int value;
	
	public static AlignmentSideEnum valueOf(int value) {
		for (AlignmentSideEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}