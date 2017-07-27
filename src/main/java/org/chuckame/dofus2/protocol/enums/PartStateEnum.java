package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PartStateEnum {
	PART_NOT_INSTALLED(0),
	PART_BEING_UPDATER(1),
	PART_UP_TO_DATE(2);
	
	@Getter
	private final int value;
	
	public static PartStateEnum valueOf(int value) {
		for (PartStateEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}